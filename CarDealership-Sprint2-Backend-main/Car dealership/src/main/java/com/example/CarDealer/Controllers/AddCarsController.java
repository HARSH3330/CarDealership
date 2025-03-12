package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.CarModel;
import com.example.CarDealer.Repository.AddCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class AddCarsController {

    @Autowired
    private AddCarsRepository addCarRepo;

    @PostMapping("/addCar")
    public ResponseEntity<Map<String,String>> addCar(@RequestBody CarModel car){
        CarModel carObj = addCarRepo.save(car);

        Map<String,String> response = new HashMap<>();

        if(carObj.getCarid() != 0){
            response.put("Status","Car added successfully");
        }
        else{
            response.put("Status","Transaction failed");
        }
        return ResponseEntity.ok(response);
    }
}
