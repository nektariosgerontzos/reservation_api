package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    Product updateById(int id, Product product);
}
