package com.nekos.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "kitchen_notifications")
public class KitchenNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "status")
    private String status;
    @Column(name = "sent_at")
    private Date sentAt;
    @Column(name = "acknowledged_at")
    private Date noticedAt;


    public KitchenNotification() {
    }

    public KitchenNotification(Integer id, Order order, String status, Date sentAt, Date noticedAt) {
        this.id = id;
        this.order = order;
        this.status = status;
        this.sentAt = sentAt;
        this.noticedAt = noticedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    public Date getNoticedAt() {
        return noticedAt;
    }

    public void setNoticedAt(Date noticedAt) {
        this.noticedAt = noticedAt;
    }
}
