package org.example.controller;

import org.example.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String vercode = req.getParameter("Vercode");
        String syscode = (String) req.getSession().getAttribute("Vercode");
        HttpSession session = req.getSession();
        System.out.println(username);
        System.out.println(password);
        resp.setContentType("text/html;charset=utf-8");
        if (!vercode.equals(syscode)) {
            String msg = "验证码错误！";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            if (username.equals("admin")) {
                if (password.equals("123456")) {
//                resp.sendRedirect("/Inspur/Game.jsp");
                    User user = new User(username, password);
                    session.setAttribute("loginUser", user);
                    req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
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
}
