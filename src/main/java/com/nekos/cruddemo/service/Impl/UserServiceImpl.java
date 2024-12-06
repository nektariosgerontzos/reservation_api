package com.nekos.cruddemo.service.Impl;

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
}
