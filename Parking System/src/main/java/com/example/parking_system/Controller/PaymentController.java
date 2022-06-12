package com.example.parking_system.Controller;

import com.example.parking_system.Service.ParkService;
import com.example.parking_system.Service.PaymentService;
import com.example.parking_system.model.API;
import com.example.parking_system.model.Park;
import com.example.parking_system.model.Payment;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments(){
        logger.info("Get payments");
        return ResponseEntity.status(200).body(paymentService.getPayments());
    }

    @PostMapping
    public ResponseEntity<API> addPayment(@RequestBody @Valid Payment payment){
        logger.info("Add payment");
        paymentService.addPayment(payment);
        return ResponseEntity.status(201).body(new API("Payment Added",201));
    }


//    @PutMapping("/update/{paymentid}")
//    public ResponseEntity<API> update(@RequestBody @Valid Payment payment,@PathVariable Integer paymentid){
//        logger.info("Update payment");
//        paymentService.update(payment, paymentid);
//        return ResponseEntity.status(201).body(new API("Payment updated",201));
//    }
//
//    @DeleteMapping("/delete/{paymentid}")
//    public ResponseEntity<API> delete(@PathVariable Integer paymentid){
//        logger.info("Delete payment");
//        paymentService.delete(paymentid);
//        return ResponseEntity.status(201).body(new API("Payment deleted",201));
//    }

}
