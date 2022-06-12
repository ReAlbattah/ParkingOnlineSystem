package com.example.parking_system.Service;

import com.example.parking_system.Exception.InvalidIdException;
import com.example.parking_system.Repo.ParkRepo;
import com.example.parking_system.Repo.PaymentRepo;
import com.example.parking_system.model.Park;
import com.example.parking_system.model.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;

    public List<Payment> getPayments(){
        return paymentRepo.findAll();
    }

    public void addPayment(Payment payment){
        paymentRepo.save(payment);
    }

    public Optional<Payment> getUPaymentById(Integer paymentid){
        return paymentRepo.findById(paymentid);
    }

    public void update(Payment payment,Integer paymentid){
        Optional<Payment> currentPayment = getUPaymentById(paymentid);
        if(currentPayment.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }

       // currentPayment.get().setReservationID(payment.getReservationID());
        currentPayment.get().setStatus(payment.getStatus());

        paymentRepo.save(currentPayment.get());
    }

    public void delete(Integer paymentid){
        Optional<Payment> currentPayment = getUPaymentById(paymentid);
        if(currentPayment.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }
        paymentRepo.delete(currentPayment.get());
    }

}
