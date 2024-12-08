package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Order findById(@PathVariable int id){
        return orderService.findById(id);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable int id){
        orderService.deleteById(id);
    }

    @PutMapping("/orders/{id}")
    public Order update(@PathVariable int id, @RequestBody Order order){
        return orderService.update(id, order);
    }

}
