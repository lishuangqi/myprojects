package com.lishuangqi.utils;

import com.lishuangqi.utils.StringUtil;

/**
 * Created by michael on 2017/10/20.
 */
public class SqlUtil {
    public SqlUtil() {
    }

    public static String getInString(String str, String patten) {
        if(str == null) {
            return "";
        } else {
            String[] arr = str.split(patten);
            StringBuilder sb = new StringBuilder();

            int post;
            for(post = 0; post < arr.length; ++post) {
                if(StringUtil.hasText(arr[post])) {
                    sb.append("\'" + arr[post] + "\',");
                }
            }

            post = sb.lastIndexOf(",");
            if(sb.length() > 0 && post > -1) {
                return sb.substring(0, post);
            } else {
                return "";
            }
        }
    }
}