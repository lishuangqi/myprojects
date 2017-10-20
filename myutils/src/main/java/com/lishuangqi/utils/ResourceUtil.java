package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourceUtil {
    public static final String PROTOCOL_FILE = "file:";
    public static final String PROTOCOL_CLASSPATH = "classpath*:";

    public ResourceUtil() {
    }

    public static InputStream getResourceAsStream(String path, Class classname) {
        InputStream inputstream = classname.getResourceAsStream(path);
        return inputstream;
    }

    public static InputStream getResourceAsStream(String path) {
        Object stream = null;
        if(StringUtil.isEmpty(path)) {
            return (InputStream)stream;
        } else {
            String trip = path.startsWith("/")?path.substring(1):path;
            if(StringUtil.hasText(trip)) {
                stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(trip);
                if(stream == null) {
                    stream = ResourceUtil.class.getClassLoader().getResourceAsStream(trip);
                }

                if(stream == null) {
                    stream = ResourceUtil.class.getResourceAsStream(trip);
                }

                if(stream == null) {
                    File e = new File(path);
                    if(e.exists()) {
                        try {
                            stream = new FileInputStream(e);
                        } catch (FileNotFoundException var9) {
                            ;
                        }
                    }
                }

//                if(stream == null) {
//                    try {
//                        URL e2 = ResourceUtils.getURL(path);
//                        if(e2 != null) {
//                            stream = e2.openStream();
//                        }
//                    } catch (FileNotFoundException var6) {
//                        var6.printStackTrace();
//                    } catch (IOException var7) {
//                        var7.printStackTrace();
//                    }
//                }
            }

            return (InputStream)stream;
        }
    }

    public static URL getResource(String path) {
        URL url = null;
        if(StringUtil.isEmpty(path)) {
            return url;
        } else {
            String trip = path.startsWith("/")?path.substring(1):path;
            if(!StringUtil.hasText(trip)) {
                url = Thread.currentThread().getContextClassLoader().getResource(trip);
                if(url == null) {
                    url = ResourceUtil.class.getClassLoader().getResource(trip);
                }

                if(url == null) {
                    url = ResourceUtil.class.getResource(trip);
                }
            }

            return url;
        }
    }
}