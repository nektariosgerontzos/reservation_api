package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.dto.UserDTO;
import com.nekos.cruddemo.entity.User;
import com.nekos.cruddemo.repository.UserRepository;
import com.nekos.cruddemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found User"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(user.getFirst_name());
        userDTO.setLastName(user.getLast_name());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();

        user.setFirst_name(userDTO.getFirstName());
        user.setLast_name(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        return user;

    }

    @Override
    public List<UserDTO> findAllDTO() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : users){
            userDTOS.add(toDTO(user));
        }

        return userDTOS;
    }


}
