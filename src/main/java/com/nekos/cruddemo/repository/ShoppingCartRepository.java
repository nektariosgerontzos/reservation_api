package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    // methods

}
