package com.nekos.cruddemo.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer id) {
        this.id = id;
    }

    public ShoppingCart(Integer id, Date created_at, Date updated_at, User user) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
