package org.example.dao;

import org.example.Utils.JDBCUtils;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
//import java.util.UUID;

public class UserDao {
    private Connection connection = JDBCUtils.getCon();
    private PreparedStatement preparedStatement = null;

    public boolean addUser(User user) {
        boolean execute = false;
        try {
            String sql = "insert into users(id, name, password, age) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            String id = UUID.randomUUID().toString().replace("-", "");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            int row = preparedStatement.executeUpdate();
            if (row > 0)
                execute = true;
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return execute;
    }

//    public User queryOne(String name, String password) {
//        User user = null;
//        try {
//            String sql = "select id, name, password, age, sex from users where name=? and password=?";
//            user = run.query(sql, new BeanHandler<>(User.class), name, password);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return user;
//    }

    public User searchOne(String name, String password) {
        User user = null;
        try {
            String sql = "select id, name, password, age, sex from users where name = ? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
            }
        } catch (Exception e) {
        }
//        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return user;
    }


}
