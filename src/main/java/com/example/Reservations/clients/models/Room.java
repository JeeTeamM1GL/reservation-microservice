package com.example.Reservations.clients.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room implements Serializable { 
    private String num_room;
    private RoomType room_type;
    private String price_per_night;
    private String capacity;
    private String description;
    private String is_available;
    private List<String> images;
    private int etage;
    private List<String> equipments;
    private Double surface;
    private Instant createdAt;
    private Instant updatedAt;
    private Hotel hotel;
}
