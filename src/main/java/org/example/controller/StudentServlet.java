package org.example.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.example.entity.Student;
import org.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Deprecated
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.queryList();
        HttpSession session = req.getSession();
        session.setAttribute("students", studentList);
        req.getRequestDispatcher("/StudentList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameters = req.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student, parameters);
            boolean achieve = studentService.addStudent(student);
            if (achieve) {
                req.getSession().setAttribute("addStudentMsg", "添加成功");
                req.getSession().setAttribute("students", studentService.queryList());
            } else {
                req.getSession().setAttribute("addStudentMsg", "添加失败");
            }
            resp.sendRedirect(req.getContextPath() + "/student");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
