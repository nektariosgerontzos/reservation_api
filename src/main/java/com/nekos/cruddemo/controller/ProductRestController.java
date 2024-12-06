package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Product;
import com.nekos.cruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    private List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    private Product findById(@PathVariable int id){
        return productService.findById(id);
    }

    @PostMapping("/products")
    private Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/products/{id}")
    private void delete(@PathVariable int id){
        productService.deleteById(id);
    }

    @PutMapping("/products/{id}")
    private Product update(@PathVariable int id, @RequestBody Product product){
        return productService.updateById(id, product);
    }

}
