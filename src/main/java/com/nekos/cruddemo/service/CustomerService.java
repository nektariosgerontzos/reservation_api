package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer findById(int id);
    Customer save(Customer customer);
    void delete(int id);
    Customer update(int id, Customer customer);

}
