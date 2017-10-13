package com.lishuangqi.utils.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title: OriginFilter.java
 * @Package: com.lishuangqi.filter
 * @Description: TODO
 * @author: lishuangqi
 * @date: 2017年6月29日 上午11:39:40
 * @version: V1.0
 */
public class OriginFilter implements Filter {

	private boolean isCross = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String isCrossStr = filterConfig.getInitParameter("IsCross");
        isCross = isCrossStr.equals("true")?true:false;
        System.out.println(isCrossStr);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(isCross){
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            //System.out.println("拦截请求: "+httpServletRequest.getServletPath());
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");  
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
            httpServletResponse.setHeader("Access-Control-Max-Age", "0");  
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");  
            httpServletResponse.setHeader("XDomainRequestAllowed","1");  
        }
        chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		isCross = false;
	}
	
}
