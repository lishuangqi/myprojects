package com.lishuangqi.utils;

import java.util.Properties;

/**
 * Created by michael on 2017/11/13.
 */
public class FrameworkProps {
    private static String configPath = "framework.properties";
    private static boolean ok = true;

    public FrameworkProps() {
    }

    public static String getPropertiesPath() {
        String resourcePath = ConfigResource.getResourcePath(configPath);
        if(ok) {
            System.out.println("useing FrameworkProps：" + resourcePath);
            ok = false;
        }

        return resourcePath;
    }

    public static Properties getProperties() {
        try {
            return PropertiesUtil.loadProperties(getPropertiesPath());
        } catch (Exception var1) {
            var1.printStackTrace();
            return new Properties();
        }
    }

    public static boolean getProperty(String propertyName, boolean defValue) {
        try {
            return PropertiesUtil.getProperties(getPropertiesPath(), propertyName, defValue);
        } catch (Exception var3) {
            var3.printStackTrace();
            return defValue;
        }
    }

    public static int getProperty(String propertyName, int defValue) {
        try {
            return PropertiesUtil.getProperties(getPropertiesPath(), propertyName, defValue);
        } catch (Exception var3) {
            var3.printStackTrace();
            return defValue;
        }
    }

    public static String getProperty(String propertyName, String defValue) {
        try {
            return PropertiesUtil.getProperties(getPropertiesPath(), propertyName, defValue);
        } catch (Exception var3) {
            var3.printStackTrace();
            return defValue;
        }
    }

    public static String getProperty(String propertyName) {
        try {
            return PropertiesUtil.getProperties(getPropertiesPath(), propertyName, (String)null);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }
}
