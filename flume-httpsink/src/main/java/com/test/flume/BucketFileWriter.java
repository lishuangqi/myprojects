package com.test.flume;

/**
 * Created by michael on 2018/3/30.
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.serialization.EventSerializer;
import org.apache.flume.serialization.EventSerializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BucketFileWriter {
    private static final Logger logger = LoggerFactory
            .getLogger(BucketFileWriter.class);
    private static final String IN_USE_EXT = ".tmp";
    /**
     * This lock ensures that only one thread can open a file at a time.
     */
    private final AtomicLong fileExtensionCounter;
    private OutputStream outputStream;
    private EventSerializer serializer;
    private String filePath;
    /**
     * Close the file handle and rename the temp file to the permanent filename.
     * Safe to call multiple times. Logs HDFSWriter.close() exceptions.
     *
     * @throws IOException
     *             On failure to rename if temp file exists.
     */
    public BucketFileWriter() {
        fileExtensionCounter = new AtomicLong(System.currentTimeMillis());
    }
    public void open(final String filePath, String serializerType,
                     Context serializerContext, final long rollInterval,
                     final ScheduledExecutorService timedRollerPool,
                     final FileWriterLinkedHashMap sfWriters) throws IOException {
        this.filePath = filePath;
        File file = new File(filePath + fileExtensionCounter + IN_USE_EXT);
        file.getParentFile().mkdirs();
        outputStream = new BufferedOutputStream(new FileOutputStream(file));
        logger.info("filename = " + file.getAbsolutePath());
        serializer = EventSerializerFactory.getInstance(serializerType,
                serializerContext, outputStream);
        serializer.afterCreate();
        if (rollInterval > 0) {
            Callable<Void> action = new Callable<Void>() {
                public Void call() throws Exception {
                    logger.debug(
                            "Rolling file ({}): Roll scheduled after {} sec elapsed.",
                            filePath + fileExtensionCounter + IN_USE_EXT,
                            rollInterval);
                    if (sfWriters.containsKey(filePath)) {
                        sfWriters.remove(filePath);
                    }
                    close();
                    return null;
                }
            };
            timedRollerPool.schedule(action, rollInterval, TimeUnit.SECONDS);
        }
    }
    public void append(Event event) throws IOException {
        serializer.write(event);
    }
    public boolean isBatchComplete() {
        return true;
    }
    public void flush() throws IOException {
        serializer.flush();
        outputStream.flush();
    }
    /**
     * Rename bucketPath file from .tmp to permanent location.
     */
    private void renameBucket() {
        File srcPath = new File(filePath + fileExtensionCounter + IN_USE_EXT);
        File dstPath = new File(filePath + fileExtensionCounter);
        if (srcPath.exists()) {
            srcPath.renameTo(dstPath);
            logger.info("Renaming " + srcPath + " to " + dstPath);
        }
    }
    public synchronized void close() throws IOException, InterruptedException {
        if (outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
        renameBucket();
    }
}