package org.example.testController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/three")
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //手动创建Cookie
        Cookie cookie = new Cookie("name", "admin" + Math.random());
        //创建Cookie之后，向Cookie发送给客户端，需要把Cookie放到响应头中。
        resp.addCookie(cookie);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print("演示创建Cookie");
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie ck: cookies) {
                resp.getWriter().print("cookie的name属性是：" + ck.getName() + "<br>");
                resp.getWriter().print("cookie的value属性是：" + ck.getValue() + "<br>");
                resp.getWriter().print("Cookie的存活时间是：" + ck.getMaxAge() + "<br>");
            }
        }
    }
}
