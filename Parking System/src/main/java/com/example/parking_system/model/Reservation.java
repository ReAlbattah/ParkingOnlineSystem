package com.example.parking_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//@SuppressWarnings("JpaAttributeTypeInspection")
@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @NotNull
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @NotNull
    private LocalDateTime endTime;

    private Double amount = 0.0;

    @ManyToOne
    private MyUser myUser;

    @ManyToOne
    private Park park;

    @ManyToOne
    @JsonIgnore
    private Payment payment;

}
