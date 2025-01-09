package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.dto.OrderDTO;
import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import com.nekos.cruddemo.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @PostMapping("/orders")
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping("/orders/{id}")
    public OrderDTO findById(@PathVariable int id){
        Order order = orderService.findById(id);
        return orderService.toDTO(order);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable int id){
        orderService.deleteById(id);
    }

    @PutMapping("/orders/{id}")
    public Order update(@PathVariable int id, @RequestBody Order order){
        return orderService.update(id, order);
    }

    @GetMapping("/ordersByTable/{id}")
    public List<Order> findByTable(@PathVariable int id){
        return orderService.findOrdersByTable(id);
    }

    @GetMapping("/orders/{orderId}/details")
    public ResponseEntity<List<OrderDetails>> getOrderDetails(@PathVariable Integer orderId) {
        List<OrderDetails> orderDetails = orderService.getOrderDetails(orderId);
        return ResponseEntity.ok(orderDetails);
    }

    @PutMapping("/orders/{orderId}/completion")
    public Order completeOrder(@PathVariable int orderId){
        return orderService.orderCompletion(orderId);
    }

    @GetMapping("/orders/{tableId}/pending")
    public List<OrderDTO> pendingOrdersPerTable(@PathVariable int tableId){
        return orderService.activeOrderByTable(tableId);
    }

}
