package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;


public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUser();

    User updateUser(User user,Long id);
}
