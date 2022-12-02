package org.example.controller;

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
        String method = request.getParameter("method");
        if (method != null) {
            try {
                //获得背访问对象的字节码对象 和 字节码对象里的指定的方法
                Method targetMethod = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
                //执行对应方法
                targetMethod.invoke(this, request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
