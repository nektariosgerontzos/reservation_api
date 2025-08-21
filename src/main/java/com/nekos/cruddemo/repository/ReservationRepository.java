package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {



}
