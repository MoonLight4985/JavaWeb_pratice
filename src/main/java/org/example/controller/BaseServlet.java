package org.example.controller;

import javax.management.Query;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet", urlPatterns = {"/base"})
public class BaseServlet extends HttpServlet {
    /**
     * 子类的servlet被访问， 调用 父类的service方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String method = request.getParameter("method");
            if (method == null) {
                method = "query";
            }
            Method md = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            md.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
