package com.nekos.cruddemo.controller;


import com.nekos.cruddemo.entity.Reservation;
import com.nekos.cruddemo.repository.ReservationRepository;
import com.nekos.cruddemo.service.Impl.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation findById(@PathVariable int id){
        return reservationService.findById(id);
    }

    @PostMapping("/reservations")
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/reservationcancel/{id}")
    public void cancelReservation(@PathVariable int id){
        reservationService.cancelReservation(id);
    }

    @PutMapping("/reservations/{id}")
    public Reservation update(@PathVariable int id, @RequestBody Reservation reservation){
        return reservationService.update(id, reservation);
    }


}
