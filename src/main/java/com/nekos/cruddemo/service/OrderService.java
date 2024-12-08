package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findById(int id);
    Order save(Order order);
    void deleteById(int id);
    Order update(int id, Order order);

}
