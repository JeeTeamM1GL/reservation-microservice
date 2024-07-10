package com.example.Reservations.repositories;

import com.example.Reservations.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByCustomerId(String customerId);
    List<Reservation> findByHotelId(String hotelId);
}

