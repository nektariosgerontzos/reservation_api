package com.nekos.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "courts")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "sport")
    private String sport;
    @Column(name = "location")
    private String location;
    @Column(name = "is_indoor")
    private Integer isIndoor;
    @Column(name = "surface_type")
    private String surfaceType;
    @Column(name = "created_at")
    private Date createdAt;


    public Court(){

    }

    public Court(Integer id, String name, String sport, String location, Integer isIndoor, String surfaceType, Date createdAt) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.location = location;
        this.isIndoor = isIndoor;
        this.surfaceType = surfaceType;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getIsIndoor() {
        return isIndoor;
    }

    public void setIsIndoor(Integer isIndoor) {
        this.isIndoor = isIndoor;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
