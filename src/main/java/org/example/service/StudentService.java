package org.example.service;

import org.example.dao.StudentDao;
import org.example.entity.Student;

import java.util.List;

public class StudentService {
    public List<Student> queryList() {
        return new StudentDao().queryList();
    }

    public boolean addStudent(Student student) {
        return new StudentDao().addStudent(student);
    }

    public boolean deleteById(int id) {
        return new StudentDao().deleteById(id);
    }
}
