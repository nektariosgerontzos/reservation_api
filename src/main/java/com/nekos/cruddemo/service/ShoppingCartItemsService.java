package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.ShoppingCartItems;

import java.util.List;

public interface ShoppingCartItemsService{

    List<ShoppingCartItems> findAll();

    ShoppingCartItems findById(int id);

    ShoppingCartItems save(ShoppingCartItems shoppingCartItems);

}
