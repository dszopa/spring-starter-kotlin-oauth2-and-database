package com.brainstormer.controller;

import org.springframework.web.bind.annotation.RestController;
import com.brainstormer.entity.User;
import com.brainstormer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

}
