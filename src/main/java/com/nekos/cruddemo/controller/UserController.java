package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.User;
import com.nekos.cruddemo.service.Impl.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }


    @PostMapping("/users")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

}
