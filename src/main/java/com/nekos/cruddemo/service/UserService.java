package com.nekos.cruddemo.service;

import com.nekos.cruddemo.dto.UserDTO;
import com.nekos.cruddemo.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    UserDTO toDTO (User user);

    User toEntity(UserDTO userDTO);

    List<UserDTO> findAllDTO();

}
