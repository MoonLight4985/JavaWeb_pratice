package org.example.testController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/two")

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        //获取session的ID，不同浏览器访问同一个项目的同一个页面，session的ID是不同的。
        //同意浏览器访问同一个项目的不同页面，sessionID相同。
        String id = session.getId();
        PrintWriter writer = resp.getWriter();
        //获取最大存活时间
        int maxInactiveInterval = session.getMaxInactiveInterval();
        writer.write("<div>TwoSessionID" + id + "</div>");
        writer.write("<div>" + maxInactiveInterval + "</div>");

        String reqname = (String) req.getAttribute("name");
        writer.print(reqname + "<br>");
        writer.print(session.getAttribute("key"));
    }
}
