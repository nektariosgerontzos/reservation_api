package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.ShoppingCartItems;
import com.nekos.cruddemo.repository.ShoppingCartItemsRepository;
import com.nekos.cruddemo.service.ShoppingCartItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemsImpl implements ShoppingCartItemsService {

    private final ShoppingCartItemsRepository shoppingCartItemsRepository;

    public ShoppingCartItemsImpl(ShoppingCartItemsRepository shoppingCartItemsRepository) {
        this.shoppingCartItemsRepository = shoppingCartItemsRepository;
    }

    @Override
    public List<ShoppingCartItems> findAll() {
        return shoppingCartItemsRepository.findAll();
    }

    @Override
    public ShoppingCartItems findById(int id) {
        return shoppingCartItemsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found"));
    }

    @Override
    public ShoppingCartItems save(ShoppingCartItems shoppingCartItems) {
        return shoppingCartItemsRepository.save(shoppingCartItems);
    }
}
