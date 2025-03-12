package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.CarModel;
import com.example.CarDealer.Repository.DisplayCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ViewCarsController {
    @Autowired
    public DisplayCarsRepository displayCarsRepo;

    @GetMapping("/viewAll")
    public ResponseEntity<List<Map<String,String>>> displayAll(){
        List<Map<String,String>> cars = displayCarsRepo.viewAllCars();

        return ResponseEntity.ok(cars);
    }
}
