package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.CarModel;
import com.example.CarDealer.Repository.DeleteCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeleteCarsController {
    @Autowired
    private DeleteCarsRepository deleteCarRepo;

    @PostMapping("/deleteCar")
    public ResponseEntity<Map<String,String>> deleteCar(@RequestBody CarModel car){
        deleteCarRepo.deleteCar(car.getCarid());

        Map<String,String> response = new HashMap<>();
        response.put("Status","Deletion successful");

        return ResponseEntity.ok(response);
    }

}



