package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // methods


}
