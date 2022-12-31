package org.example.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.example.entity.Student;
import org.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/stud")
public class NewStudentServlet extends BaseServlet {

    private StudentService studentService = new StudentService();

    public void add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameters = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student, parameters);
            boolean achieve = studentService.addStudent(student);
            if (achieve) {
                request.getSession().setAttribute("addStudentMsg", "添加成功");
                request.getSession().setAttribute("students", studentService.queryList());
            } else {
                request.getSession().setAttribute("addStudentMsg", "添加失败");
            }
            try {
                response.sendRedirect(request.getContextPath() + "/stud");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void del(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        boolean achieve = studentService.deleteById(id);
        try {
            response.sendRedirect(request.getContextPath() + "/stud");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update执行");
        Map<String, String[]> parameters = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        boolean b = studentService.putStu(student);
        try {
            response.sendRedirect(request.getContextPath() + "/stud");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void query(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.queryList();
        HttpSession session = request.getSession();
        session.setAttribute("students", studentList);
        try {
            request.getRequestDispatcher("/StudentList.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SelectById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.selectById(id);
        request.getSession().setAttribute("putStudent", student);
        try {
            request.getRequestDispatcher("/putStu.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
