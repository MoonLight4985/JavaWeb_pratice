package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        resp.setContentType("text/html;charset=utf-8");
        if (username.equals("admin")) {
            if (password.equals("123456")) {
//                resp.sendRedirect("/Inspur/Game.jsp");
                req.getRequestDispatcher("/Game.jsp").forward(req, resp);
            } else {
                String msg = "用户名或密码错误！";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            String msg = "用户名或密码错误！";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
