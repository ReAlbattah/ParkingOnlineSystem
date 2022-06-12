package com.example.parking_system.Service;

import com.example.parking_system.Exception.InvalidIdException;
import com.example.parking_system.Repo.ParkRepo;
import com.example.parking_system.model.Park;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkService {
    private final ParkRepo parkRepo;

    public List<Park> getParks(){
        return parkRepo.findAll();
    }

    public void addPark(Park park){
        parkRepo.save(park);
    }

    public Optional<Park> getParkById(Integer parkid){
        return parkRepo.findById(parkid);
    }

    public void update(Park park,Integer parkid){
        Optional<Park> currentPark = getParkById(parkid);
        if(currentPark.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }

        currentPark.get().setParkNumber(park.getParkNumber());
        currentPark.get().setSection(park.getSection());
        currentPark.get().setPricePerHour(park.getPricePerHour());

        parkRepo.save(currentPark.get());
    }

    public void delete(Integer parkid){
        Optional<Park> currentPark = getParkById(parkid);
        if(currentPark.isEmpty()){
            throw new InvalidIdException("Invalid id");
        }
        parkRepo.delete(currentPark.get());
    }


}
