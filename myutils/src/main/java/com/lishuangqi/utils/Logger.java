package com.lishuangqi.utils;


import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by michael on 2017/11/13.
 */

public class Logger {
    public static org.slf4j.Logger log = LoggerFactory.getLogger(Logger.class);
    private static Map<String, org.slf4j.Logger> logMap = new HashMap();

    public Logger() {
    }

    public static void debug(String message) {
        getLogger((String)null).debug(getMethodName() + message);
    }

    public static void debug(String message, String logName) {
        getLogger(logName).debug(getMethodName() + message);
    }

    public static void debug(String message, Throwable t) {
        getLogger((String)null).debug(getMethodName() + message, t);
    }

    public static void debug(String message, Throwable t, String logName) {
        getLogger(logName).debug(getMethodName() + message, t);
    }

    public static void info(String message) {
        getLogger((String)null).info(getMethodName() + message);
    }

    public static void info(String message, String logName) {
        getLogger(logName).info(getMethodName() + message);
    }

    public static void info(String message, Throwable t) {
        getLogger((String)null).info(getMethodName() + message, t);
    }

    public static void info(String message, Throwable t, String logName) {
        getLogger(logName).info(getMethodName() + message, t);
    }

    public static void warn(String message) {
        getLogger((String)null).warn(getMethodName() + message);
    }

    public static void warn(String message, String logName) {
        getLogger(logName).warn(getMethodName() + message);
    }

    public static void warn(String message, Throwable t) {
        getLogger((String)null).warn(getMethodName() + message, t);
    }

    public static void warn(String message, Throwable t, String logName) {
        getLogger(logName).warn(getMethodName() + message, t);
    }

    public static void error(String message) {
        getLogger((String)null).error(getMethodName() + message);
    }

    public static void error(String message, String logName) {
        getLogger(logName).error(getMethodName() + message);
    }

    public static void error(String message, Throwable t) {
        getLogger((String)null).error(getMethodName() + message, t);
    }

    public static void error(String message, Throwable t, String logName) {
        getLogger(logName).error(getMethodName() + message, t);
    }

    public static String getMethodName() {
        String msg = "";
        StackTraceElement[] trace = (new Exception()).getStackTrace();
        StackTraceElement element = trace[2];
        if(element != null) {
            msg = element.getClassName() + "." + element.getMethodName() + "(" + element.getFileName() + ":" + element.getLineNumber() + ") " + msg;
        }

        return msg;
    }

    public static org.slf4j.Logger getLogger(String logName) {
        if(logName != null && !logName.isEmpty()) {
            org.slf4j.Logger log2 = (org.slf4j.Logger)logMap.get(logName);
            if(log2 == null) {
                log2 = LoggerFactory.getLogger(logName);
                logMap.put(logName, log2);
            }

            return log2;
        } else {
            return log;
        }
    }
}

