package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Integer> {
}
