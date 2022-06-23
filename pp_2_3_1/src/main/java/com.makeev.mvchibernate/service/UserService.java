package com.makeev.mvchibernate.service;

import com.makeev.mvchibernate.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void updateUser(User user);
    void deleteUser(User user);
    void deleteUserById(Long id);
}