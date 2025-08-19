package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.User;
import com.nekos.cruddemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Did not found."));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User updatedUser) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
