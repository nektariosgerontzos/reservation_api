package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Product;
import com.nekos.cruddemo.repository.ProductRepository;
import com.nekos.cruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateById(int id, Product product) {
        return productRepository.findById(id)
                .map(existinproduct -> {
                    existinproduct.setAvailable(product.getAvailable());
                    existinproduct.setName(product.getName());
                    existinproduct.setPrice(product.getPrice());
                    existinproduct.setProductCategory(product.getProductCategory());
                    existinproduct.setCreatedAt(product.getCreatedAt());
                    return productRepository.save(existinproduct);
                })
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}
