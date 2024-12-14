package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import com.nekos.cruddemo.entity.Product;
import com.nekos.cruddemo.repository.OrderDetailsRepository;
import com.nekos.cruddemo.repository.OrderRepository;
import com.nekos.cruddemo.repository.ProductRepository;
import com.nekos.cruddemo.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

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
        OrderDetails orderDetails1 = orderDetails;
        Integer productId = orderDetails1.getProduct().getId();
        Optional<Product> product = productRepository.findById(productId);
        System.out.println("+++++++++"+ product.toString());
        if (!product.isEmpty()){
            orderDetails1.setPrice(product.get().getPrice().multiply(new BigDecimal(orderDetails.getQuantity())));
        }
        return orderDetailsRepository.save(orderDetails1);
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
