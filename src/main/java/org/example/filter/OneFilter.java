package org.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/*  ")
public class OneFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("这是OneFilter，初始化！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        System.out.println("拦截到的地址是：" + uri);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("OneFilter销毁了!");
    }
}
