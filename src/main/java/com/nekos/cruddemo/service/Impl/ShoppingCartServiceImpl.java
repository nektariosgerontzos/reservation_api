package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.ShoppingCart;
import com.nekos.cruddemo.repository.ShoppingCartRepository;
import com.nekos.cruddemo.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart findById(int id) {
        return shoppingCartRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found"));
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }
}
