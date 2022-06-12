package com.example.parking_system.Controller;

import com.example.parking_system.Service.ParkService;
import com.example.parking_system.Service.ReservationService;
import com.example.parking_system.model.API;
import com.example.parking_system.model.Park;
import com.example.parking_system.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private
    Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        logger.info("Get reservations");
        return ResponseEntity.status(200).body(reservationService.getReservations());
    }

    @PostMapping
    public ResponseEntity<API> addReservation(@RequestBody @Valid Reservation reservation){
        logger.info("Add reservation");

        reservationService.addReservation(reservation);
        return ResponseEntity.status(201).body(new API("Reservation Added",201));
    }


    @PutMapping("/update/{reservationid}")
    public ResponseEntity<API> update(@RequestBody @Valid Reservation reservation,@PathVariable Integer reservationid){
        logger.info("Update reservations");
        reservationService.update(reservation, reservationid);
        return ResponseEntity.status(201).body(new API("Reservation updated",201));
    }

    @DeleteMapping("/delete/{reservationid}")
    public ResponseEntity<API> delete(@PathVariable Integer reservationid){
        logger.info("Delete reservations");
        reservationService.delete(reservationid);
        return ResponseEntity.status(201).body(new API("Reservation deleted",201));
    }

}
