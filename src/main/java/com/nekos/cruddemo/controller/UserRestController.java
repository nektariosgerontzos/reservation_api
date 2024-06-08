package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.dto.UserDTO;
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
    public List<UserDTO> findAll(){
        return userService.findAllDTO();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }


    @PostMapping("/users")
    public User save(@RequestBody User user){
        return userService.save(user);
    }






}
