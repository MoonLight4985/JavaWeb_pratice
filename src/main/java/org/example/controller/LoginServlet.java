package org.example.controller;

import org.example.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.Set;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受浏览器地址栏发送的请求
        HttpSession session = req.getSession();
        //先判断session中是否保存有用户的信息,能取到就说明用户登陆过
        User user = (User) session.getAttribute("loginUser");
        if (user != null) {
            //登陆过了
            String name = user.getUsername();
            String password = user.getPassword();
            if (name.equals("admin") && password.equals("123456"))
                req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
        } else {
            //没有登陆过，先去登录
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);
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
                    //用户登录成功之后，将用户名和密码保存到Cookie
                    username = URLEncoder.encode(username, "UTF-8");
                    password = URLEncoder.encode(password, "UTF-8");
                    Cookie nameCookie = new Cookie("Username", username);
                    nameCookie.setMaxAge(5 * 86400);
                    Cookie passwordCookie = new Cookie("Password", password);
                    passwordCookie.setMaxAge(5 * 86400);
                    resp.addCookie(nameCookie);
                    resp.addCookie(passwordCookie);
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
