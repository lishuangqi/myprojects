package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ParamUtil {
    public ParamUtil() {
    }

    public static String getParameter(HttpServletRequest request, String key, String def) {
        String val = request.getParameter(key);
        return !StringUtil.hasText(val)?def:val;
    }

    public static Object getRequestAttr(HttpServletRequest request, String key, Object def) {
        Object obj = request.getAttribute(key);
        return obj == null?def:obj;
    }

    public static Object getSessionAttr(HttpSession session, String key, Object def) {
        Object obj = session.getAttribute(key);
        return obj == null?def:obj;
    }
}
