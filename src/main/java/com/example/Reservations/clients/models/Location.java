package com.example.Reservations.clients.models;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location implements Serializable {
    private String address;
    private String country;
    private String city;
}
