package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import com.nekos.cruddemo.repository.OrderDetailsRepository;
import com.nekos.cruddemo.repository.OrderRepository;
import com.nekos.cruddemo.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails findById(int id) {
        return orderDetailsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("OrderDetails not found."));
    }

    @Override
    public void delete(int id) {
        orderDetailsRepository.deleteById(id);
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails update(int id, OrderDetails orderDetails) {
        return orderDetailsRepository.findById(id)
                .map(existingDetail -> {
                    existingDetail.setOrder(orderDetails.getOrder());
                    existingDetail.setProduct(orderDetails.getProduct());
                    existingDetail.setQuantity(orderDetails.getQuantity());
                    existingDetail.setPrice(orderDetails.getPrice());
                    existingDetail.setCreatedAt(orderDetails.getCreatedAt());
                    return orderDetailsRepository.save(existingDetail);
                })
                .orElseThrow(()-> new IllegalArgumentException("Detail not found"));
    }

    @Override
    public List<OrderDetails> findByOrder(int order_id) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return orderDetailsRepository.findByOrder(order);

    }
}
