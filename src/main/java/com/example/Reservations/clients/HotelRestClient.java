package com.example.Reservations.clients;

import com.example.Reservations.clients.models.Hotel;
import com.example.Reservations.clients.models.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelRestClient {

    @GetMapping("/api/v1/hotels/{id}")
    Hotel findHotelById(@PathVariable String id);

    default Hotel getDefaultHotel(String id , Exception exception ) {
        Hotel hotel = new Hotel();
        hotel.setId("Not available");
        hotel.setName("Not available");
        return hotel;
    }

    @GetMapping("/api/v1/rooms/{id}")
    Room findRoomById(@PathVariable String id);

    default Room getDefaultRoom(String id , Exception exception ) {
        Room room = new Room();
        room.setId("Not available");
        room.setNum_room("Not available");
        room.setCapacity("Not available");
        room.setDescription("Not available");
        return room;
    }

}

