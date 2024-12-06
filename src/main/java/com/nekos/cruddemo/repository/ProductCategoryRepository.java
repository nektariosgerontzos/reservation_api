package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
