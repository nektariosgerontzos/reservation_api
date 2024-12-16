package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Customer;
import com.nekos.cruddemo.repository.CustomerRepository;
import com.nekos.cruddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer did not found"));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(int id, Customer customer) {
        return customerRepository.findById(id)
                .map(existing -> {
                    existing.setCreatedAt(customer.getCreatedAt());
                    existing.setEmail(customer.getEmail());
                    existing.setName(customer.getName());
                    existing.setPhone(customer.getPhone());
                    return customerRepository.save(existing);
                })
                .orElseThrow(()-> new IllegalArgumentException("Customer not found."));
    }
}
