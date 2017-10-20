package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */

import com.lishuangqi.utils.filter.IFileFilter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class FileUtil {
    public static final String FILE_SEPARATER = "\\";
    public static final String OFFICE_SUFFIX = ".doc,.xls,.ppt,.docx,.xlsx,.pptx";
    public static final String PIC_SUFFIX = ".bmp,.jpg,.jpeg,.png,.gif";
    public static final String VIDIO_SUFFIX = ".avi,.mkv,.mp4,.m4v,.flv";
    public static final String RADIO_SUFFIX = ".wav,.mp1,.mp2,.mp3,.mp4,.wma";
    public static final int TYPE_OFFICE = 0;
    public static final int TYPE_PIC = 1;
    public static final int TYPE_VIDIO = 2;
    public static final int TYPE_RADIO = 3;

    public FileUtil() {
    }

    public static boolean exists(String path) {
        if(StringUtil.isEmpty(path)) {
            return false;
        } else {
            File file = new File(path);
            return file.exists();
        }
    }

    public static String getFileNameOfNoExtention(File file) {
        if(file != null && !file.isDirectory()) {
            String name = file.getName();
            int indexOfDot = name.lastIndexOf(".");
            return indexOfDot == -1?name:name.substring(0, indexOfDot);
        } else {
            return null;
        }
    }

    public static String[] getFolderByPath(String path) {
        if(!StringUtil.hasText(path)) {
            return null;
        } else {
            String[] folderArray = null;
            File file = new File(path);
            if(file != null) {
                path = StringUtil.replace(path, "\\", "/");
                folderArray = path.split("/");
                folderArray = ArrayUtil.removeElemetByEqual(folderArray, "");
                folderArray = ArrayUtil.removeElemetByContain(folderArray, ":");
            }

            System.out.println("file is:" + file.isFile());
            if(file.isFile() && folderArray.length > 1) {
                folderArray = (String[])((String[])ArrayUtil.remove(folderArray, folderArray.length - 1));
            }

            return folderArray;
        }
    }

    public static void main(String[] args) {
        String[] folderArray = getFolderByPath("D:/wsplatform/我的/wsbp-framework/WSBPBuild/config/platform/ftp.properties");
        if(folderArray != null) {
            System.out.println("folderArray:" + folderArray.length);

            for(int i = 0; i < folderArray.length; ++i) {
                System.out.println(i + " " + folderArray[i]);
            }
        } else {
            System.out.println("folderArray is null");
        }

    }

    public static void createFolder(String path) {
        File file = new File(path);
        file.mkdirs();
    }

    public static boolean exists(String dir, String filename) {
        if(!StringUtil.isEmpty(dir) && !StringUtil.isEmpty(filename)) {
            File file = new File(dir, filename);
            return file.exists();
        } else {
            return false;
        }
    }

    public static long getFileSize(File file) {
        long len = 0L;
        if(!file.exists()) {
            return len;
        } else {
            if(file.isFile()) {
                len = file.length();
            } else {
                File[] files = file.listFiles();

                for(int i = 0; i < files.length; ++i) {
                    len += getFileSize(files[i]);
                }
            }

            return len;
        }
    }

    public static long getFileSize(String dir, String filename) {
        File file = new File(dir, filename);
        long len = 0L;
        if(!file.exists()) {
            return len;
        } else {
            if(file.isFile()) {
                len = file.length();
            } else {
                File[] files = file.listFiles();

                for(int i = 0; i < files.length; ++i) {
                    len += getFileSize(files[i]);
                }
            }

            return len;
        }
    }

    public static String getFolderName(String filePath) {
        String fileName = getBaseFileName(filePath);
        return !StringUtil.isEmpty(fileName)?filePath.substring(0, filePath.lastIndexOf(fileName) - 1):null;
    }

    public static String getBaseFileName(String filePath) {
        String fileName = (new File(filePath)).getName();
        int colonIndex = fileName.indexOf(":");
        if(colonIndex == -1) {
            colonIndex = fileName.indexOf("\\\\");
        }

        int backslashIndex = fileName.lastIndexOf("\\");
        if(colonIndex > -1 && backslashIndex > -1) {
            fileName = fileName.substring(backslashIndex + 1);
        }

        return fileName;
    }

    public static void copyDirectiory(String sourceDir, String targetDir, String[] suffix) throws IOException {
        File targetDirectiory = new File(targetDir);
        if(!targetDirectiory.exists()) {
            (new File(targetDir)).mkdirs();
        }

        File[] file = (new File(sourceDir)).listFiles();

        for(int i = 0; i < file.length; ++i) {
            if(file[i].isFile()) {
                File dir1 = file[i];
                if(suffix != null) {
                    boolean dir2 = false;
                    String str = "";

                    try {
                        str = dir1.getAbsolutePath().substring(dir1.getAbsolutePath().lastIndexOf(".") + 1, dir1.getAbsolutePath().length());
                    } catch (Exception var10) {
                        str = "";
                    }

                    for(int j = 0; j < suffix.length; ++j) {
                        if(suffix[j].equals(str)) {
                            dir2 = true;
                            break;
                        }
                    }

                    if(!dir2) {
                        continue;
                    }
                }

                File var12 = new File((new File(targetDir)).getAbsolutePath() + File.separator + file[i].getName());
                copyFile(dir1, var12);
            }

            if(file[i].isDirectory()) {
                String var11 = sourceDir + "/" + file[i].getName();
                String var13 = targetDir + "/" + file[i].getName();
                copyDirectiory(var11, var13);
            }
        }

    }

    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        copyDirectiory(sourceDir, targetDir, (String[])null);
    }

    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);
        File parentFile = targetFile.getParentFile();
        if(parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }

        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);
        byte[] b = new byte[5120];

        int len;
        while((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }

        outBuff.flush();
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    public static void createNewFile(InputStream inputStream, String path) throws Exception {
        File file = new File(path);
        if(!file.exists()) {
            createNewFile(file);
        }

        BufferedInputStream inBuff = new BufferedInputStream(inputStream);
        FileOutputStream output = new FileOutputStream(path);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);
        byte[] b = new byte[5120];

        int len;
        while((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }

        outBuff.flush();
        inBuff.close();
        outBuff.close();
        output.close();
    }

    public static synchronized void deleteDirectiory(String targetFile) {
        File f = new File(targetFile);
        if(!f.isDirectory()) {
            f.delete();
        } else {
            File[] file = f.listFiles();
            if(file != null && file.length != 0) {
                for(int i = 0; i < file.length; ++i) {
                    if(file[i].isFile()) {
                        file[i].delete();
                    }

                    if(file[i].isDirectory()) {
                        deleteDirectiory(file[i].getAbsolutePath());
                    }
                }

                if(f.listFiles() == null || f.listFiles().length == 0) {
                    f.delete();
                }

            } else {
                f.delete();
            }
        }
    }

    public static synchronized void deleteDirectiory(File targetFile) {
        deleteDirectiory(targetFile.getAbsolutePath());
    }

    public static boolean isUTF8(String path) {
        boolean b = false;

        try {
            if(exists(path)) {
                FileInputStream e = new FileInputStream(path);
                byte[] buffer = new byte[3];
                e.read(buffer);
                if(buffer[0] == -17 && buffer[1] == -69 && buffer[2] == -65) {
                    b = true;
                }

                e.close();
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return b;
    }

    public static String hashDir(int id) {
        return hashDir("/file/", id);
    }

    public static String hashDir(String basedir, int id) {
        int i1 = id % 100;
        int i2 = id / 100 % 100;
        String s = String.format("%02d/%02d", new Object[]{Integer.valueOf(i1), Integer.valueOf(i2)});
        File dir = new File(basedir + s);
        if(!dir.isDirectory()) {
            dir.mkdirs();
        }

        return s;
    }

    public static String hashDirSingle(String basedir, int id, boolean autoCreate) {
        int i1 = id % 100;
        String s = String.format("%02d", new Object[]{Integer.valueOf(i1)});
        File dir = new File(basedir + s);
        if(autoCreate && !dir.isDirectory()) {
            dir.mkdirs();
        }

        return s;
    }

    public static String hashDirNoCreate(int id) {
        int i1 = id % 100;
        int i2 = id / 100 % 100;
        String s = String.format("%02d/%02d", new Object[]{Integer.valueOf(i1), Integer.valueOf(i2)});
        return s + "/" + id;
    }

    public static List<Map<String, Object>> nameToLowerCase(List<Map<String, Object>> l) {
        ArrayList tempList = new ArrayList();
        Iterator i$ = l.iterator();

        while(i$.hasNext()) {
            Map m = (Map)i$.next();
            HashMap mm = new HashMap();
            Iterator i$1 = m.keySet().iterator();

            while(i$1.hasNext()) {
                String s = (String)i$1.next();
                mm.put(s.toLowerCase(), m.get(s));
            }

            tempList.add(mm);
        }

        return tempList;
    }

    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return pos == -1?"":fileName.substring(pos + 1).toLowerCase();
    }

    public static File createNewFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) {
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            file.createNewFile();
        }

        return file;
    }

    public static File createNewFile(File file) throws IOException {
        if(!file.exists()) {
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            file.createNewFile();
        }

        return file;
    }

    public static List<File> getAllFiles(String directory, String extensionName) {
        List files = getAllFiles(directory);
        ArrayList result = new ArrayList();
        int i = 0;

        for(int len = files.size(); i < len; ++i) {
            File f = (File)files.get(i);
            String name = getExtention(f.getName());
            if(!StringUtil.isEmpty(name) && name.equals(extensionName.toLowerCase())) {
                result.add(f);
            }
        }

        return result;
    }

    public static synchronized List<File> getAllFiles(String directory) {
        ArrayList result = new ArrayList();
        File f = new File(directory);
        File[] files = f.listFiles();
        if(!CollectionUtil.isEmpty(files)) {
            for(int i = 0; i < files.length; ++i) {
                File f1 = files[i];
                if(f1.isDirectory()) {
                    result.addAll(getAllFiles(f1.getAbsolutePath()));
                } else {
                    result.add(f1);
                }
            }
        }

        return result;
    }

    public static synchronized List<File> getAllFiles(String directory, IFileFilter filter) {
        ArrayList result = new ArrayList();
        File f = new File(directory);
        File[] files = f.listFiles();
        if(!CollectionUtil.isEmpty(files)) {
            for(int i = 0; i < files.length; ++i) {
                File f1 = files[i];
                if(f1.isDirectory()) {
                    result.addAll(getAllFiles(f1.getAbsolutePath(), filter));
                } else if(filter.isTarget(f1.getName())) {
                    result.add(f1);
                }
            }
        }

        return result;
    }

    public static synchronized List<File> getAllFiles1(String directory, IFileFilter filter) {
        ArrayList result = new ArrayList();
        File f = new File(directory);
        File[] files = f.listFiles();
        if(!CollectionUtil.isEmpty(files)) {
            for(int i = 0; i < files.length; ++i) {
                File f1 = files[i];
                if(f1.isDirectory() && filter.isTarget(f1.getName())) {
                    result.addAll(getAllFiles(f1.getAbsolutePath(), filter));
                } else if(filter.isTarget(f1.getName())) {
                    result.add(f1);
                }
            }
        }

        return result;
    }

    public static String getCharset(File file) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];

        try {
            boolean e = false;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            bis.close();
            if(read == -1) {
                return charset;
            }

            if(first3Bytes[0] == -1 && first3Bytes[1] == -2) {
                charset = "UTF-16LE";
                e = true;
            } else if(first3Bytes[0] == -2 && first3Bytes[1] == -1) {
                charset = "UTF-16BE";
                e = true;
            } else if(first3Bytes[0] == -17 && first3Bytes[1] == -69 && first3Bytes[2] == -65) {
                charset = "UTF-8";
                e = true;
            }

            bis.reset();
            if(!e) {
                label72:
                do {
                    do {
                        if((read = bis.read()) == -1 || read >= 240 || 128 <= read && read <= 191) {
                            break label72;
                        }

                        if(192 <= read && read <= 223) {
                            read = bis.read();
                            continue label72;
                        }
                    } while(224 > read || read > 239);

                    read = bis.read();
                    if(128 <= read && read <= 191) {
                        read = bis.read();
                        if(128 <= read && read <= 191) {
                            charset = "UTF-8";
                        }
                    }
                    break;
                } while(128 <= read && read <= 191);
            }

            bis.close();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return charset;
    }

    public static File getFileByName(File file, String fileName) {
        File[] files = file.listFiles();

        for(int i = 0; i < files.length; ++i) {
            File result = files[i];
            if(result.getName().toLowerCase().indexOf(fileName) != -1) {
                return result;
            }
        }

        return null;
    }

    public static List<String> readFileByLine(File file) throws IOException {
        ArrayList list = new ArrayList();
        FileReader reader = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(reader);
        String str = null;

        while((str = bufferReader.readLine()) != null) {
            list.add(str);
        }

        return list;
    }

    public static int getFileType(File sourceFile) {
        if(sourceFile != null) {
            String[] vidioSuffixArray = ".avi,.mkv,.mp4,.m4v,.flv".split(",");

            for(int officeSuffixArray = 0; officeSuffixArray < vidioSuffixArray.length; ++officeSuffixArray) {
                if(sourceFile.getPath().toLowerCase().endsWith(vidioSuffixArray[officeSuffixArray])) {
                    return 2;
                }
            }

            String[] var6 = ".doc,.xls,.ppt,.docx,.xlsx,.pptx".split(",");

            for(int picSuffixArray = 0; picSuffixArray < var6.length; ++picSuffixArray) {
                if(sourceFile.getPath().toLowerCase().endsWith(var6[picSuffixArray])) {
                    return 0;
                }
            }

            String[] var7 = ".bmp,.jpg,.jpeg,.png,.gif".split(",");

            for(int radioSuffixArray = 0; radioSuffixArray < var7.length; ++radioSuffixArray) {
                if(sourceFile.getPath().toLowerCase().endsWith(var7[radioSuffixArray])) {
                    return 1;
                }
            }

            String[] var8 = ".wav,.mp1,.mp2,.mp3,.mp4,.wma".split(",");

            for(int i = 0; i < var8.length; ++i) {
                if(sourceFile.getPath().toLowerCase().endsWith(var8[i])) {
                    return 3;
                }
            }
        }

        return -1;
    }
}

