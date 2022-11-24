package org.example.dao;

import org.example.Utils.JDBCUtils;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDao {
    private Connection connection = JDBCUtils.getCon();
    private PreparedStatement preparedStatement = null;

    public int addUser(User user) {
        int count = 0;
        try {
            connection.setAutoCommit(false);
            String sql = "insert into users(id, name, password, age, sex values(?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            String id = UUID.randomUUID().toString().replace("-", "");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getSex());
            count = preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        }
        return count;
    }

    public User searchOne(String name, String password) {
        User user = null;
        try {
            System.out.println("1010");
            String sql = "select id, name, password, age, sex from users where name = ? and password=?";
            System.out.println("2020");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
            }
        } catch (Exception e) {
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }
}
