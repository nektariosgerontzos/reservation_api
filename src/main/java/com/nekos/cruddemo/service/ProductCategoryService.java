package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAll();
    ProductCategory findById(int id);
    ProductCategory save(ProductCategory productCategory);
    ProductCategory update(int id, ProductCategory productCategory);
    void deleteById(int id);

}
