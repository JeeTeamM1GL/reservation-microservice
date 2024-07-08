package com.example.Reservations.clients.models;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Telephone implements Serializable {
    private String indicatif;
    private String number;
}
