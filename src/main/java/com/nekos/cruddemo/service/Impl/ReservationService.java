package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();

    Reservation save(Reservation reservation);

    Reservation findById(int id);

    List<Reservation> findAllByCourtId(int courtId);

    Reservation update(int id, Reservation reservation);

    void deleteById(int id);

    void cancelReservation(int id);


}
