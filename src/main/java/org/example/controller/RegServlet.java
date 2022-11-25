package org.example.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.example.entity.User;
import org.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    private static final long serivalVersionUID = 1L;
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            Map<String, String[]> parameters = req.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, parameters);
            int count = userService.addUser(user);
            resp.setContentType("text/html;charsert=UTF-8");
            PrintWriter writer = resp.getWriter();
            if (count > 0) {
                writer.print("<div>用户注册成功，<a href='/Inspur/login.jsp'>去登录</a></div>");
            } else {
                writer.print("<div>用户注册失败，<a href='/Inspur/reg.jsp'>重新注册</a></div>");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
