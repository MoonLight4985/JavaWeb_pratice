package org.example.dao;

import org.example.Utils.JDBCUtils;
import org.example.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection connection = JDBCUtils.getCon();
    private PreparedStatement preparedStatement = null;
    public List<Student> queryList() {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setSid(rs.getString("sid"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setSex(rs.getString("sex"));
                stu.setGrade(rs.getInt("grade"));
                students.add(stu);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
