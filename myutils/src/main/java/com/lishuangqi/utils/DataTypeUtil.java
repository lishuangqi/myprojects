package com.lishuangqi.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by michael on 2017/10/13.
 */
public class DataTypeUtil {
    public DataTypeUtil() {
    }

    public static String convertObject2String(Object obj) {
        if(obj != null) {
            if(obj instanceof Date) {
                return DateUtil.formatDateToString((Date)obj, "yyyy-MM-dd HH:mm:ss");
            }

            if(obj instanceof Integer) {
                return String.valueOf((Integer)obj);
            }

            if(obj instanceof Double) {
                return String.valueOf((Integer)obj);
            }

            if(obj instanceof Long) {
                return String.valueOf((Long)obj);
            }

            if(obj instanceof Float) {
                return String.valueOf((Float)obj);
            }

            if(obj instanceof BigDecimal) {
                return ((BigDecimal)obj).toString();
            }

            if(obj instanceof String) {
                return (String)obj;
            }
        }

        return "";
    }
}
