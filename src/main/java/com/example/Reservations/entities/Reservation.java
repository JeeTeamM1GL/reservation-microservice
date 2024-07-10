package com.example.Reservations.entities;
import com.example.Reservations.clients.models.Hotel;
import com.example.Reservations.clients.models.Room;
import com.example.Reservations.clients.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservations")
public class Reservation implements Serializable {
    @Id
    private String id;

    @Column(name = "date_arrivee", nullable = false)
    private Instant dateArrivee;

    @Column(name = "date_depart", nullable = false)
    private Instant dateDepart;

    @Column(name = "duree_sejour", nullable = false)
    private int dureeSejour;

    @Column(name = "person_count", nullable = false)
    private int personCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "moyen_paiement", nullable = false)
    private PaymentMethod moyenPaiement;

    @Column(name = "options")
    private String options; // Vous pouvez changer le type selon vos besoins

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "customer")
    private User customer;

    @Column(name = "hotelId")
    private String hotelId;

    @Column(name = "hotel")
    private Hotel hotel;

    @Column(name = "roomId")
    private String roomId;

    @Column(name = "room")
    private Room room;


}

