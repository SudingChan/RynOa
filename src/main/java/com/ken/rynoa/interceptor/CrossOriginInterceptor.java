package com.ken.rynoa.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author joseph
 * @create 2018-02-24 上午 10:51
 * @desc 跨域拦截器
 **/

public class CrossOriginInterceptor implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, Accept, TOKEN, Content-Range, Content-Disposition, Content-Description");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json; charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void destroy() {

    }
}
