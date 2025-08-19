package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Court;

import java.util.List;

public interface CourtService {

    List<Court> findAll();
    Court findById(Integer id);
    Court save(Court court);
    void deleteById(Integer id);
    Court updateCourt(Integer id, Court court);

}
