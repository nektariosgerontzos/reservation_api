package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> findAll();

    ShoppingCart findById(int id);

    ShoppingCart save(ShoppingCart shoppingCart);


}
