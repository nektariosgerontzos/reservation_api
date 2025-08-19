package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.CourtAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtAvailabilityRepository extends JpaRepository<CourtAvailability, Integer> {
}
