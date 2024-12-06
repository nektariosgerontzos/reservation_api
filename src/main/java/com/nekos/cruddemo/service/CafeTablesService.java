package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.CafeTables;
import com.nekos.cruddemo.entity.User;

import java.util.List;

public interface CafeTablesService {

    List<CafeTables> findAll();

    CafeTables findById(int id);

    CafeTables save(CafeTables cafeTables);

    CafeTables updateUser(int id, CafeTables cafeTables);

    void deleteById(int id);
}
