package com.lishuangqi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 2017/11/13.
 */
public class SystemEnvUtil {
    private static Map<String, String> prop = new HashMap();

    public SystemEnvUtil() {
    }

    public static String getSystemEnvironment(String varName) {
        String v = (String)prop.get(varName);
        if(!StringUtil.hasText(v)) {
            v = System.getProperty(varName);
        }

        if(!StringUtil.hasText(v)) {
            v = System.getenv(varName);
        }

        return v;
    }

    public static void setSystemProperty(String name, String value) {
        prop.put(name, value);
    }

    public static String getSystemProperty(String name) {
        return (String)prop.get(name);
    }

    public static void removeSystemProperty(String name) {
        prop.remove(name);
    }

    public static String replace(String str) {
        if(str != null && !str.isEmpty()) {
            String result = str;
            int pos_start = str.indexOf("${");
            if(pos_start >= 0) {
                StringBuilder builder = new StringBuilder();

                int pos_end;
                for(pos_end = -1; pos_start >= 0; pos_start = str.indexOf("${", pos_end + 1)) {
                    builder.append(str, pos_end + 1, pos_start);
                    pos_end = str.indexOf(125, pos_start + 2);
                    if(pos_end < 0) {
                        pos_end = pos_start - 1;
                        break;
                    }

                    String propName = str.substring(pos_start + 2, pos_end);
                    String replacement;
                    if(propName.length() == 0) {
                        replacement = null;
                    } else {
                        replacement = getSystemEnvironment(propName);
                    }

                    if(replacement != null) {
                        builder.append(replacement);
                    } else {
                        builder.append(str, pos_start, pos_end + 1);
                    }
                }

                builder.append(str, pos_end + 1, str.length());
                result = builder.toString();
            }

            return result;
        } else {
            return str;
        }
    }
}

