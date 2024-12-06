package com.nekos.cruddemo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @Column(name = "created_at")
    private Date createdAt;


    public Product() {
    }

    public Product(Integer id, String name, ProductCategory productCategory, BigDecimal price, Boolean isAvailable, Date createdAt) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
