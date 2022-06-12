package com.example.parking_system.Repo;

import com.example.parking_system.model.MyUser;
import com.example.parking_system.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepo extends JpaRepository<Park,Integer> {

    @Query(value = "SELECT COUNT(park_id) FROM parking.reservation where park_id=?1 AND start_time < now() AND now()< end_time",nativeQuery = true)
    Integer checkParkAvailability(Integer parkID);// checks if the park is available
}
