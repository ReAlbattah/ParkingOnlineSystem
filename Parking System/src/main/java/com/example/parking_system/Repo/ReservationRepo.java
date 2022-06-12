package com.example.parking_system.Repo;

import com.example.parking_system.model.MyUser;
import com.example.parking_system.model.Payment;
import com.example.parking_system.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Integer> {

    @Query(value = "SELECT id FROM parking.reservation where my_user_id=?1 AND start_time < now() AND now()< end_time",nativeQuery = true)
    Integer checkReservationTime(Integer userID);// checks if there is a valid reservation



}
