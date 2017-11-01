package com.lishuangqi.common.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by michael on 2017/10/31.
 */
public class XssFilter implements Filter {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        Enumeration<String> names = request.getParameterNames();
//        while (names.hasMoreElements()) {
//            String name = names.nextElement();
//            String[] values = request.getParameterValues(name);
//            for (String value : values) {
//                value = clearXss(value);
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
//    }

    protected Pattern[] ignorePattern = null;
    PathMatcher matcher = new AntPathMatcher();
    String[] ignoreStrs = null;
    @Override
    public void init(FilterConfig config) throws ServletException {
        String ignore = config.getInitParameter("ignore");
        ignore = StringUtils.defaultIfEmpty(ignore, "");
        this.ignoreStrs = ignore.replaceAll("\\s", "").split(",");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        if(! this.checkIgnore(uri)) {
            XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(request);
            chain.doFilter(xssRequest, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    public boolean checkIgnore(String requestUrl) {
        boolean flag = false;
        String[] var6 = this.ignoreStrs;
        int var5 = this.ignoreStrs.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            String pattern = var6[var4];
            if(flag = this.matcher.match(pattern, requestUrl)) {
                break;
            }
        }

        return flag;
    }

}
