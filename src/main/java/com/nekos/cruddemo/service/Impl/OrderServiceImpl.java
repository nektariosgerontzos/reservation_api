package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.repository.OrderRepository;
import com.nekos.cruddemo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found"));
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
