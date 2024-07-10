package com.example.Reservations.clients.models;

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
public class Hotel implements Serializable {
    private String id;
    private String name;
    private Location location;
    private int rooms_count;
    private String description;
    private String cover;
    private List<String> images;
    private String gps_coordinate;
    private Instant createdAt;
    private Instant updatedAt;
    private List<Room> rooms;
    //private List<Commentaire> commentaires;
}
