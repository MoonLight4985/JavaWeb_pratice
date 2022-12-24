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

    public boolean addStudent(Student student) {
        boolean achieve = false;
        try {
            String sql = "insert into student(sid, name, age, grade, sex, avatar) values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getSid());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setInt(4, student.getGrade());
            preparedStatement.setString(5, student.getSex());
            preparedStatement.setString(6, student.getAvatar());
            achieve = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return achieve;
    }

    public boolean deleteById(int id) {
        boolean achieve = false;
        try {
//            connection.setAutoCommit(false);
            System.out.println(id);
            String sql = "delete from student where id= ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
            if (count > 0)
                achieve = true;
            System.out.println(achieve);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return achieve;
    }

    public Student selectById(int id) {
        Student student = new Student();
        try {
            String sql = "select * from student where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setSid(rs.getString("sid"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setGrade(rs.getInt("grade"));
                student.setAvatar(rs.getString("avatar"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return student;
    }

    public boolean putStu(Student stu) {
        boolean achieve = false;
        try {
            String sql = "update student set sid=?, name=?, age=?, grade=?, sex=?, avatar=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stu.getSid());
            preparedStatement.setString(2, stu.getName());
            preparedStatement.setInt(3, stu.getAge());
            preparedStatement.setInt(4, stu.getGrade());
            preparedStatement.setString(5, stu.getSex());
            preparedStatement.setString(6, stu.getAvatar());
            preparedStatement.setInt(7, stu.getId());
            achieve = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return achieve;
    }
}
