package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.User;
import com.nekos.cruddemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id){
        userService.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User user = new User();
        try {
            user = userService.updateUser(id, updatedUser);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return user;
    }



}
