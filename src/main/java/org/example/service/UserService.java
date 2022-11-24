package org.example.service;

import org.example.dao.UserDao;
import org.example.entity.User;

public class UserService {
    public int addUser(User user) {
        return new UserDao().addUser(user);
    }
    public User searchOne(String name, String password) {
        System.out.println("000");
        return new UserDao().searchOne(name, password);
    }
}
