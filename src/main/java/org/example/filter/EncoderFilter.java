package org.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class EncoderFilter implements Filter {
    private String encode = null;

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("编码是" + encode);
        request.setCharacterEncoding(encode);
        chain.doFilter(request, response);
    }
}
