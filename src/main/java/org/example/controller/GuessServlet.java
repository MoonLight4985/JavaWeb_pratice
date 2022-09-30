package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    private int random = (int) (Math.random() * 100 + 1);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        System.out.println(random);
//        System.out.println(number);
        int num = Integer.valueOf(number);
        System.out.println("num" + num);
        System.out.println("random" + random);
        if (num == random) {
            String msg = "猜中了！";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/Game.jsp").forward(req, resp);
            System.out.println("access");
        } else if (num > random) {
            String msg = "大了！";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/Game.jsp").forward(req, resp);

            System.out.println("大了");
        } else {
            String msg = "小了！";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/Game.jsp").forward(req, resp);

            System.out.println("小了");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
