package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.dto.UserDTO;
import com.nekos.cruddemo.entity.User;
import com.nekos.cruddemo.repository.UserRepository;
import com.nekos.cruddemo.service.UserService;
import org.springframework.stereotype.Service;

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
                .orElseThrow(()-> new RuntimeException("User not found."));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setPassword(updatedUser.getPassword());
                    existingUser.setRole(updatedUser.getRole());
                    existingUser.setCreated_at(updatedUser.getCreated_at());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setCreated_at(userDTO.getCreatedAt());
        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());
        userDTO.setCreatedAt(user.getCreated_at());

        return userDTO;
    }

    @Override
    public UserDTO findByIdDTO(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found"));
        if(user != null){
            return toDTO(user);
        }
        return new UserDTO();
    }
}
