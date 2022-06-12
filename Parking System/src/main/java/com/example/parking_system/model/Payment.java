package com.example.parking_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotEmpty
    private String status;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
