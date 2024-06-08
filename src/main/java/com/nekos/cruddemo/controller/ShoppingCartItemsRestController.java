package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.ShoppingCartItems;
import com.nekos.cruddemo.service.ShoppingCartItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartItemsRestController {

    private final ShoppingCartItemsService shoppingCartItemsService;

    public ShoppingCartItemsRestController(ShoppingCartItemsService shoppingCartItemsService) {
        this.shoppingCartItemsService = shoppingCartItemsService;
    }

    @GetMapping("/cartitems")
    public List<ShoppingCartItems> findAll(){
        return shoppingCartItemsService.findAll();
    }

    @GetMapping("/cartitems/{id}")
    public ShoppingCartItems findById(@PathVariable int id){
        return shoppingCartItemsService.findById(id);
    }

    @PostMapping("/cartitems")
    public ShoppingCartItems save(@RequestBody ShoppingCartItems shoppingCartItems){
        return shoppingCartItemsService.save(shoppingCartItems);
    }

}
