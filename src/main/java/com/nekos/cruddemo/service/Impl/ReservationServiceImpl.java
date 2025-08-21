package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Reservation;
import com.nekos.cruddemo.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {


    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findById(int id) {
        return reservationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
    }

    @Override
    public List<Reservation> findAllByCourtId(int courtId) {
        return List.of();
    }

    @Override
    public Reservation update(int id, Reservation reservation) {
        return reservationRepository.findById(id)
                .map(existingReservation -> {
                    existingReservation.setCourt(reservation.getCourt());
                    existingReservation.setReservationDate(reservation.getReservationDate());
                    existingReservation.setCreatedAt(reservation.getCreatedAt());
                    existingReservation.setEndTime(reservation.getEndTime());
                    existingReservation.setStartTime(reservation.getStartTime());
                    existingReservation.setStatus(reservation.getStatus());
                    existingReservation.setUser(reservation.getUser());
                    return reservationRepository.save(existingReservation);
                })
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void cancelReservation(int id) {
        Reservation reservation = findById(id);
        if(reservation != null){
            reservation.setStatus("CANCELLED");
            update(id, reservation);
        }
    }
}
