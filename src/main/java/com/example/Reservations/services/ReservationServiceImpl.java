package com.example.Reservations.services;

import com.example.Reservations.clients.CustomerRestClient;
import com.example.Reservations.clients.HotelRestClient;
import com.example.Reservations.clients.models.Hotel;
import com.example.Reservations.clients.models.Room;
import com.example.Reservations.clients.models.User;
import com.example.Reservations.core.utils.IDGenerate;
import com.example.Reservations.dto.ReservationDto;
import com.example.Reservations.entities.Reservation;
import com.example.Reservations.repositories.ReservationRepository;
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

    @Autowired
    private final HotelRestClient hotelRestClient;

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
                .customerId(reservationDto.getCustomerId())
                .hotelId(reservationDto.getHotelId())
                .roomId(reservationDto.getRoomId())
                .build();
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        var list = reservationRepository.findAll();
        list.forEach(c->{
            var room = hotelRestClient.findRoomById(c.getRoomId());
            c.setRoom(room);
            var hotel = hotelRestClient.findHotelById(c.getHotelId());
            c.setHotel(hotel);
            var customer = customerRestClient.findCustomerById(c.getCustomerId());
            c.setCustomer(customer);
        });
        return list ;
    }

    public List<Reservation> findReservationsByCustomerId(String id) {
        var list = reservationRepository.findByCustomerId(id);
        list.forEach(c->{
            var room = hotelRestClient.findRoomById(c.getRoomId());
            c.setRoom(room);
            var hotel = hotelRestClient.findHotelById(c.getHotelId());
            c.setHotel(hotel);
            var customer = customerRestClient.findCustomerById(c.getCustomerId());
            c.setCustomer(customer);
        });
        return list;
    }


    public List<Reservation> findReservationsByHotelId(String id) {
        var list = reservationRepository.findByHotelId(id);
        list.forEach(c->{
            var room = hotelRestClient.findRoomById(c.getRoomId());
            c.setRoom(room);
            var hotel = hotelRestClient.findHotelById(c.getHotelId());
            c.setHotel(hotel);
            var customer = customerRestClient.findCustomerById(c.getCustomerId());
            c.setCustomer(customer);
        });
        return list;
    }


    public Optional<Reservation> findReservationById(String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);

        var room = hotelRestClient.findRoomById(reservation.get().getRoomId());
        reservation.get().setRoom(room);
        var hotel = hotelRestClient.findHotelById(reservation.get().getHotelId());
        reservation.get().setHotel(hotel);
        var customer = customerRestClient.findCustomerById(reservation.get().getCustomerId());
        reservation.get().setCustomer(customer);

        reservation.orElse(null).setCustomer(customer);
        reservation.orElse(null).setHotel(hotel);
        reservation.orElse(null).setRoom(room);

        return reservation;
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
