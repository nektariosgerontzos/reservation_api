package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Customer;
import com.nekos.cruddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @PostMapping("/customer")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable int id){
        return customerService.findById(id);
    }
    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
    @PutMapping("/customer/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer customer){
        return customerService.update(id, customer);
    }

}
