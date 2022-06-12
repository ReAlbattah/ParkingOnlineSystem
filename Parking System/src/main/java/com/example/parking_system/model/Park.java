package com.example.parking_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Park {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty
    private String parkNumber;
    @NotEmpty
    private String section;
    @NotNull
    private Double pricePerHour;


    @OneToMany(mappedBy = "park",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations;

}
