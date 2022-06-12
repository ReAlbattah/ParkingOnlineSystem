package com.example.parking_system.Service;

import com.example.parking_system.Exception.InvalidCarPlateException;
import com.example.parking_system.Exception.InvalidIdException;
import com.example.parking_system.Exception.NoValidReservationException;
import com.example.parking_system.Repo.MyUserRepo;
import com.example.parking_system.Repo.ReservationRepo;
import com.example.parking_system.model.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
public class MyUserService {
    private final MyUserRepo myUserRepo;
    private final ReservationRepo reservationRepo;

    public List<MyUser> getUsers(){
        return myUserRepo.findAll();
    }

    public void addUser(MyUser myUser){
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepo.save(myUser);
    }

    public Optional<MyUser> getUserById(Integer userid){
        return myUserRepo.findById(userid);
    }

    public void update(MyUser myUser,Integer userid){
        Optional<MyUser> currentUser = getUserById(userid);
        if(currentUser.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }
        currentUser.get().setCarPlate(myUser.getCarPlate());
        currentUser.get().setEmail(myUser.getEmail());
        currentUser.get().setPhoneNumber(myUser.getPhoneNumber());
        currentUser.get().setRole(myUser.getRole());
        currentUser.get().setUsername(myUser.getUsername());
        currentUser.get().setPassword(myUser.getPassword());

        myUserRepo.save(currentUser.get());
    }
    public void delete(Integer userid){
        Optional<MyUser> currentUser = getUserById(userid);
        if(currentUser.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }
        myUserRepo.delete(currentUser.get());
    }


    public void securCheck(String carPlate){
        Optional<MyUser> user = myUserRepo.findByCarPlate(carPlate);
        if(user.isEmpty()){
            throw new InvalidCarPlateException("Car plate not registered !") ;
        }

            Integer reservation=  reservationRepo.checkReservationTime(user.get().getId());

        if (reservation == null){
            throw new NoValidReservationException("There is no valid reservation for this car !");
        }
    }

}
