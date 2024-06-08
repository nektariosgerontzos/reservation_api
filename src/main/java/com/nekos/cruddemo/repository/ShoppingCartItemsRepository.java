package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.ShoppingCartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemsRepository extends JpaRepository<ShoppingCartItems, Integer> {
}
