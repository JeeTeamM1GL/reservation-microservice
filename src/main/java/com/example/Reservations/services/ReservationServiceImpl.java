package com.example.Reservations.services;

import com.example.Reservations.clients.CustomerRestClient;
import com.example.Reservations.clients.models.User;
import com.example.Reservations.core.utils.IDGenerate;
import com.example.Reservations.dto.ReservationDto;
import com.example.Reservations.entities.Reservation;
import com.example.Reservations.repositories.ReservationRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService{

    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final CustomerRestClient customerRestClient;

    public Reservation createReservation(ReservationDto reservationDto) {
        Reservation reservation= Reservation.builder()
                .id(IDGenerate.generate("RSV"))
                .dateArrivee(reservationDto.getDateArrivee())
                .dateDepart(reservationDto.getDateDepart())
                .dureeSejour(reservationDto.getDureeSejour())
                .personCount(reservationDto.getPersonCount())
                .status(reservationDto.getStatus())
                .moyenPaiement(reservationDto.getMoyenPaiement())
                .options(reservationDto.getOptions())
                .build();
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        System.out.println(reservationRepository.findAll());
        return reservationRepository.findAll() ;
    }

    public Optional<Reservation> findReservationById(String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        User customer = customerRestClient.findCustomerById(reservation.orElse(null).getCustomerId());
        reservation.orElse(null).setCustomer(customer);
        return reservation;
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
