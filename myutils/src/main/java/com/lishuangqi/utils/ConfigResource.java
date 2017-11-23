package com.lishuangqi.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

/**
 * Created by michael on 2017/11/13.
 */
public class ConfigResource {
    public static final String CONFIG_PATH_FOR_FRAMEWORK = "/framework/config/";
    public static final String I18N_PATH_FOR_FRAMEWORK = "/framework/i18n/";

    public ConfigResource() {
    }

    public static String getResourcePath(String fileName) {
        String filePath = "classpath:" + fileName;
        String home = SystemEnvUtil.getSystemEnvironment("BUILD_HOME");
        if (home == null) {
            home = "";
        }

        try {
            File e = ResourceUtils.getFile(filePath);
            if (e == null || !e.exists()) {
                filePath = "file:" + home + "/framework/config/" + fileName;
            }
        } catch (FileNotFoundException var4) {
            filePath = "file:" + home + "/framework/config/" + fileName;
        }

        return filePath;
    }

    public static String getI18nResourcePath(String i18nResource, Locale locale) throws FileNotFoundException {
        if (locale == null) {
            locale = Locale.CHINA;
        }

        String i18nResourceName = i18nResource + "_" + locale.toString() + ".properties";
        String filePath = "classpath:i18n/" + i18nResourceName;
        String homeI18N = SystemEnvUtil.getSystemEnvironment("BUILD_HOME");
        if (homeI18N == null) {
            homeI18N = "";
        }

        homeI18N = "file:" + homeI18N + "/framework/i18n/";
        File resource = null;

        try {
            resource = ResourceUtils.getFile(filePath);
            if (resource == null || !resource.exists()) {
                filePath = homeI18N + i18nResourceName;
                resource = ResourceUtils.getFile(filePath);
            }
        } catch (FileNotFoundException var7) {
//            Logger.error("FileNotFoundException", var7);
            filePath = homeI18N + i18nResourceName;
            resource = ResourceUtils.getFile(filePath);
            if (resource == null || !resource.exists()) {
                throw new FileNotFoundException(filePath);
            }
        }

        return filePath;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getI18nResourcePath("errorCode", (Locale) null));
        } catch (FileNotFoundException var2) {
            System.out.println("aaa");
        }

    }
}

