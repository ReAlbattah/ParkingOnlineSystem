package com.example.parking_system.Controller;

import com.example.parking_system.Service.MyUserService;
import com.example.parking_system.Service.ParkService;
import com.example.parking_system.model.API;
import com.example.parking_system.model.MyUser;
import com.example.parking_system.model.Park;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/park")
@RequiredArgsConstructor
public class ParkController {

    private final ParkService parkService;
    Logger logger = LoggerFactory.getLogger(ParkController.class);

    @GetMapping
    public ResponseEntity<List<Park>> getParks(){
        logger.info("Get parks");
        return ResponseEntity.status(200).body(parkService.getParks());
    }

    @PostMapping("/owner/add")
    public ResponseEntity<API> ownerAddPark(@RequestBody @Valid Park park){
        logger.info("Add park");
        parkService.addPark(park);
        return ResponseEntity.status(201).body(new API("Park ready to use",201));
    }


    @PutMapping("/update/{parkid}")
    public ResponseEntity<API> update(@RequestBody @Valid Park park,@PathVariable Integer parkid){
        logger.info("Update park");
        parkService.update(park,parkid);
        return ResponseEntity.status(201).body(new API("Park updated",201));
    }

    @DeleteMapping("/delete/{parkid}")
    public ResponseEntity<API> delete(@PathVariable Integer parkid){
        logger.info("Delete park");
        parkService.delete(parkid);
        return ResponseEntity.status(201).body(new API("Park deleted",201));
    }

}
