package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    private final OrderService orderService;


    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable int id){
        return orderService.findById(id);
    }

    @PostMapping("/orders")
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }



}
