package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    User save(User user);

    User updateUser(Integer id, User updatedUser);

    void deleteById(Integer id);

}
