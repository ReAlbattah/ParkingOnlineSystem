package com.example.parking_system.Service;

import com.example.parking_system.Exception.InvalidIdException;
import com.example.parking_system.Exception.ParkNotAvailableException;
import com.example.parking_system.Exception.UserDoubleReservationException;
import com.example.parking_system.Repo.MyUserRepo;
import com.example.parking_system.Repo.ParkRepo;
import com.example.parking_system.Repo.PaymentRepo;
import com.example.parking_system.Repo.ReservationRepo;
import com.example.parking_system.model.Payment;
import com.example.parking_system.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepo reservationRepo;
    private final MyUserRepo myUserRepo;
    private final ParkRepo parkRepo;
    private final ParkService parkService;
    private final MyUserService myUserService;



    public List<Reservation> getReservations(){
        return reservationRepo.findAll();
    }

    public void addReservation(Reservation reservation){
//       if(myUserService.getUserById(reservation.getMyUser().getId()).get().equals(Optional.empty()))
//           throw new InvalidIdException("User id not found");
//        System.out.println(myUserService.getUserById(reservation.getMyUser().getId()).get());
//       if(parkService.getParkById(reservation.getPark().getId()).get().equals(Optional.empty()))
//           throw new InvalidIdException("park id not found");
//
//        if (myUserRepo.checkReservation(reservation.getMyUser().getId().intValue())>0)
//            throw new UserDoubleReservationException(" You already have a valid reservation ");

        if (parkRepo.checkParkAvailability(reservation.getPark().getId())>0)
            throw new ParkNotAvailableException(" Park is already reserved , please choose another parking. ");

        Integer hours=reservation.getEndTime().getHour() - reservation.getStartTime().getHour();
        Double amount= hours*parkService.getParkById(reservation.getPark().getId()).get().getPricePerHour();
        reservation.setAmount(amount);


       reservationRepo.save(reservation);
    }

    public Optional<Reservation> getUReservationById(Integer reservationid){
        return reservationRepo.findById(reservationid);
    }

    public void update(Reservation reservation,Integer reservationid){
        Optional<Reservation> currentReservation = getUReservationById(reservationid);
        if(currentReservation.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }

        currentReservation.get().setMyUser(reservation.getMyUser());
        currentReservation.get().setPark(reservation.getPark());

        reservationRepo.save(currentReservation.get());
    }

    public void delete(Integer reservationid){
        Optional<Reservation> currentReservation = getUReservationById(reservationid);
        if(currentReservation.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }
        reservationRepo.delete(currentReservation.get());
    }


}
