package com.example.cg.service;

import com.example.cg.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(Integer userId, User user);

    void deleteUserById(Integer userId);

    User getUserById(Integer userId);

    List<User> getUsers();
}
