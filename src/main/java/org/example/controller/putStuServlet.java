package org.example.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.example.entity.Student;
import org.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/putStu")
public class putStuServlet extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.selectById(id);
        req.getSession().setAttribute("putStudent", student);
        req.getRequestDispatcher("/putStu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameters = req.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(student);
        boolean b = studentService.putStu(student);
        resp.sendRedirect(req.getContextPath() + "/student");
    }
}
