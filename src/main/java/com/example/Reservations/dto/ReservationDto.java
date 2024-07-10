package com.example.Reservations.dto;

import com.example.Reservations.entities.BookingStatus;
import com.example.Reservations.entities.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Instant dateArrivee;

    private Instant dateDepart;

    private int dureeSejour;

    private int personCount;

    private BookingStatus status;

    private PaymentMethod moyenPaiement;

    private String options; // Vous pouvez changer le type selon vos besoins

    private String customerId;

    private String hotelId;

    private String roomId;


}
