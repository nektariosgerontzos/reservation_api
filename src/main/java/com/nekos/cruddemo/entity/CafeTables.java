package com.nekos.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cafe_tables")
public class CafeTables {
    @Id
    @Column(name = "table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "table_number")
    private Integer number;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private Date created_at;

    public CafeTables() {
    }

    public CafeTables(Integer id, Integer number, Integer capacity, String status, Date created_at) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.status = status;
        this.created_at = created_at;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
