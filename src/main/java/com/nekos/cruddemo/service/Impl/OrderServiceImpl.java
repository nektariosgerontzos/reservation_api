package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.dto.OrderDTO;
import com.nekos.cruddemo.entity.CafeTables;
import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import com.nekos.cruddemo.entity.Product;
import com.nekos.cruddemo.repository.CafeTablesRepository;
import com.nekos.cruddemo.repository.OrderRepository;
import com.nekos.cruddemo.service.OrderDetailsService;
import com.nekos.cruddemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CafeTablesRepository cafeTablesRepository;
    @Autowired
    private OrderDetailsService orderDetailsService;

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

    @Override
    public List<Order> findOrdersByTable(int id) {
        CafeTables table = cafeTablesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return orderRepository.findByTable(table);

    }

    public List<OrderDetails> getOrderDetails(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return order.getOrderDetails();
    }

    @Override
    public BigDecimal calculateTotalPrice(Integer orderId) {
        List<OrderDetails> orderDetails = getOrderDetails(orderId);
        BigDecimal total = new BigDecimal(0);
        for(OrderDetails i: orderDetails){
            total = total.add(i.getPrice());
        }
        return total;
    }

    @Override
    public Order orderCompletion(int orderid) {
        Order order = findById(orderid);
        order.setTotalPrice(calculateTotalPrice(orderid));
        order.setUpdatedAt(new Date());
        order.setStatus("completed");
        return orderRepository.save(order);
    }

    @Override
    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        List<OrderDetails> orderDetails = getOrderDetails(order.getId());
        List<Product> products = new ArrayList<>();
        for(OrderDetails i: orderDetails){
            products.add(i.getProduct());
        }
        dto.setProducts(products);
        dto.setCreatedAt(order.getCreatedAt());
        dto.setTotalPrice(order.getTotalPrice());

        return dto;

    }


}
