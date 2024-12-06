package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.ProductCategory;
import com.nekos.cruddemo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCategoryRestController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/productcategory")
    private List<ProductCategory> findAll(){
        return productCategoryService.findAll();
    }

    @PostMapping("/productcategory")
    private ProductCategory save(@RequestBody ProductCategory productCategory){
        return productCategoryService.save(productCategory);
    }

    @DeleteMapping("/productcategory/{id}")
    private void deleteById(@PathVariable int id){
        productCategoryService.deleteById(id);
    }

    @GetMapping("/productcategory/{id}")
    private ProductCategory findById(@PathVariable int id){
        return productCategoryService.findById(id);
    }

    @PutMapping("/productcategory/{id}")
    private ProductCategory update(@PathVariable int id, @RequestBody ProductCategory productCategory){
        ProductCategory productCategory1 = new ProductCategory();
        try {
            productCategory1 = productCategoryService.update(id, productCategory);
        }catch (IllegalArgumentException e){
            return null;
        }
        return productCategory1;
    }


}
