package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.OrderDetails;
import com.nekos.cruddemo.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailsRestController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/details")
    public List<OrderDetails> findAll(){
        return orderDetailsService.findAll();
    }

    @PostMapping("/details")
    public OrderDetails save(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.save(orderDetails);
    }

    @GetMapping("/details/{id}")
    public OrderDetails findById(@PathVariable int id){
        return orderDetailsService.findById(id);
    }

    @DeleteMapping("/details/{id}")
    public void delete(@PathVariable int id){
        orderDetailsService.delete(id);
    }

    @PutMapping("/details/{id}")
    public OrderDetails update(@PathVariable int id, @RequestBody OrderDetails orderDetails){
        return orderDetailsService.update(id, orderDetails);
    }

}
