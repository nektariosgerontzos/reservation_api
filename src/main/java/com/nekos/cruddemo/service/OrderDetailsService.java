package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    List<OrderDetails> findAll();
    OrderDetails findById(int id);
    void delete(int id);
    OrderDetails save(OrderDetails orderDetails);
    OrderDetails update(int id, OrderDetails orderDetails);

}
