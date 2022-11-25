package org.example.service;

import org.example.dao.StudentDao;
import org.example.entity.Student;

import java.util.List;

public class StudentService {
    public List<Student> queryList() {
        return new StudentDao().queryList();
    }
}
