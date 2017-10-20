package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    private static Map<String, Properties> propertiesMap = new HashMap();

    public PropertiesUtil() {
    }

    public static Properties loadProperties(String configPath) throws Exception {
        if(propertiesMap.get(configPath) == null) {
            InputStream is = ResourceUtil.getResourceAsStream(configPath);
            Properties p = new Properties();
            p.load(is);
            is.close();
            propertiesMap.put(configPath, p);
            return p;
        } else {
            return (Properties)propertiesMap.get(configPath);
        }
    }

    public static String getProperties(String configPath, String propertyName) throws Exception {
        return getProperties(configPath, propertyName, "");
    }

    public static String getProperties(String configPath, String propertyName, String defalueValue) throws Exception {
        Properties p = loadProperties(configPath);
        if(StringUtil.hasText(propertyName)) {
            String properties_obj = p.getProperty(propertyName);
            if(properties_obj != null) {
                return properties_obj;
            }
        }

        return defalueValue;
    }

    public static int getProperties(String configPath, String propertyName, int defalueValue) throws Exception {
        Properties p = loadProperties(configPath);
        if(StringUtil.hasText(propertyName)) {
            String properties_obj = p.getProperty(propertyName);
            if(properties_obj != null) {
                return Integer.parseInt(properties_obj);
            }
        }

        return defalueValue;
    }

    public static boolean getProperties(String configPath, String propertyName, boolean defalueValue) throws Exception {
        Properties p = loadProperties(configPath);
        String properties_obj = p.getProperty(propertyName);
        return StringUtil.hasText(propertyName) && properties_obj != null?"true".equalsIgnoreCase(properties_obj):defalueValue;
    }

    public static boolean setProperties(String propertiesFileDir, String propertiesFileName, String propertyName, String propertyValue) {
        boolean writeOK = true;
        Properties p = new Properties();
        File file = new File(propertiesFileDir, propertiesFileName);
        if(!file.exists()) {
            try {
                FileUtil.createNewFile(file);
            } catch (IOException var21) {
                writeOK = false;
                var21.printStackTrace();
            }
        }

        FileOutputStream out = null;

        try {
            FileInputStream in = new FileInputStream(file);
            p.load(in);
            in.close();
            p.setProperty(propertyName, propertyValue);
            out = new FileOutputStream(file);
            p.store(out, "");
            out.flush();
        } catch (Exception var19) {
            writeOK = false;
            var19.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException var18) {
                ;
            }

        }

        return writeOK;
    }
}