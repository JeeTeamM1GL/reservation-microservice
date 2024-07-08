package com.example.Reservations.clients.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Telephone telephone;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled = false;
    private Instant createdAt;
    private Instant updatedAt;
}
