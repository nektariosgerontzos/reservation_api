package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.Shift;

import java.util.List;

public interface ShiftService {

    List<Shift> findAll();
    Shift findById(int id);
    void deleteById(int id);
    Shift update(int id, Shift shift);
    Shift save(Shift shift);


}
