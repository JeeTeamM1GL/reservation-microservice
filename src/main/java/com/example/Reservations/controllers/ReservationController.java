package com.example.Reservations.controllers;

import com.example.Reservations.dto.ReservationDto;
import com.example.Reservations.entities.Reservation;
import com.example.Reservations.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservations")
@AllArgsConstructor
public class ReservationController {

    @Autowired
    private final IReservationService reservationService;




    /*public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }*/

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationService.createReservation(reservationDto));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Reservation>> getReservationsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(reservationService.findReservationsByHotelId(hotelId));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable String customerId) {
        return ResponseEntity.ok(reservationService.findReservationsByCustomerId(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> findReservationById(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

}


