package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.ProductCategory;
import com.nekos.cruddemo.repository.ProductCategoryRepository;
import com.nekos.cruddemo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findById(int id) {
        return productCategoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory update(int id, ProductCategory productCategory) {
        return productCategoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setName(productCategory.getName());
                    existingCategory.setCreated_at(productCategory.getCreated_at());
                    return productCategoryRepository.save(existingCategory);
                    })
                    .orElseThrow(() -> new IllegalArgumentException("Product Category with id " + id + " not found."));
    }

    @Override
    public void deleteById(int id) {
        productCategoryRepository.deleteById(id);
    }
}
