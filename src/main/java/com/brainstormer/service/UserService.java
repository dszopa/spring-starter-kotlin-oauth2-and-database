package com.brainstormer.service;

import com.brainstormer.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User> findAllUsers();
    void deleteAllUsers();
    boolean isUserExist(User user);
}
