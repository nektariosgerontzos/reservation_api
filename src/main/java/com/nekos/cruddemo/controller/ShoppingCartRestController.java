package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.ShoppingCart;
import com.nekos.cruddemo.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartRestController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/shoppingcarts")
    public List<ShoppingCart> findAll(){
        return shoppingCartService.findAll();
    }


    @GetMapping("/shoppingcarts/{id}")
    public ShoppingCart findById(@PathVariable int id){
        return shoppingCartService.findById(id);
    }

    @PostMapping("/shoppingcarts")
    public ShoppingCart save(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.save(shoppingCart);
    }



}
