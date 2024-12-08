package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.repository.OrderRepository;
import com.nekos.cruddemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found."));
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order update(int id, Order order) {
        return orderRepository.findById(id)
                .map(existingorder -> {
                    existingorder.setCafeTable(order.getCafeTable());
                    existingorder.setUser(order.getUser());
                    existingorder.setCreatedAt(order.getCreatedAt());
                    existingorder.setUpdatedAt(order.getUpdatedAt());
                    existingorder.setStatus(order.getStatus());
                    existingorder.setTotalPrice(order.getTotalPrice());
                    return orderRepository.save(existingorder);
                })
                .orElseThrow(() -> new IllegalArgumentException("Order to be updated not found"));
    }
}
