package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    User updateUser(int id, User updatedUser);

    void deleteById(int id);

}
