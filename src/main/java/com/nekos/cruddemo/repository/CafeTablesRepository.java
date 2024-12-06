package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.CafeTables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeTablesRepository extends JpaRepository<CafeTables, Integer> {
    // methods
}
