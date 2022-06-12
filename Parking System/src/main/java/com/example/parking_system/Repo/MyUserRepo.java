package com.example.parking_system.Repo;

import com.example.parking_system.model.MyUser;
import com.example.parking_system.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Integer> {


 MyUser findUsersByUsername(String username);
 Optional<MyUser> findByCarPlate(String carPlate);


    @Query(value = "SELECT id FROM parking.reservation where user_id=?1 AND start_time < now() AND now()< end_time",nativeQuery = true)
    Integer checkReservation(Integer userid);
}

