package com.example.Reservations.services;

import com.example.Reservations.dto.ReservationDto;
import com.example.Reservations.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface IReservationService  {
    Reservation createReservation(ReservationDto reservationDto);
    List<Reservation> findAllReservations();
    List<Reservation> findReservationsByCustomerId(String id);
    List<Reservation> findReservationsByHotelId(String id);
    Optional<Reservation> findReservationById(String id);
    void deleteReservation(String id);
}
