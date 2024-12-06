package com.nekos.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "created_at")
    private Date created_at;

    public ProductCategory() {
    }

    public ProductCategory(Integer id, String name, Date created_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
