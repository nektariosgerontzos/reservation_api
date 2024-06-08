package com.nekos.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart_items")
public class ShoppingCartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public ShoppingCartItems() {
    }

    public ShoppingCartItems(Integer id, Integer quantity, ShoppingCart shoppingCart, Book book) {
        this.id = id;
        this.quantity = quantity;
        this.shoppingCart = shoppingCart;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
