package org.example.service;

import org.example.dao.UserDao;
import org.example.entity.User;

public class UserService {
    public boolean addUser(User user) {
        return new UserDao().addUser(user);
    }
    public User searchOne(String name, String password) {
        return new UserDao().searchOne(name, password);
    }
}
