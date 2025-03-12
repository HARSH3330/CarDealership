package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.CarModel;
import com.example.CarDealer.Repository.UpdateCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UpdateCarsController {
    @Autowired
    private UpdateCarsRepository updateCarRepo;

    @PostMapping("/updateCar")
    public ResponseEntity<Map<String,String>> updateCar(@RequestBody CarModel car){
        updateCarRepo.updateCar(car.getCarid(),car.getColour(),car.getKms_driven(),car.getMake(),car.getModel(),car.getNo_owners(),car.getPrice(),car.getStatus(),car.getYear());

        Map<String,String> response = new HashMap<>();
        response.put("Status","Update successful");

        return ResponseEntity.ok(response);
    }
}
