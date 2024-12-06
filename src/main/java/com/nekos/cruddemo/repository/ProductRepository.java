package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
