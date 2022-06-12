package com.example.parking_system.Repo;

import com.example.parking_system.model.MyUser;
import com.example.parking_system.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
