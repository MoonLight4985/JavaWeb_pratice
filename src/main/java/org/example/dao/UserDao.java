package org.example.dao;

//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
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

//    private QueryRunner run = new QueryRunner(JDBCUtils.getDataSource());

    public int addUser(User user) {
        int count = 0;
        try {
            connection.setAutoCommit(false);
            String sql = "insert into users(id, name, password, age, sex) values(?, ?, ?, ?, ?)";
            String id = UUID.randomUUID().toString().replace("-", "");
//            count = run.update(connection, sql, id, user.getName(), user.getPassword(), user.getAge(), user.getSex());
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
