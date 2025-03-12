package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.CarModel;
import com.example.CarDealer.Models.SalesModel;
import com.example.CarDealer.Repository.AddCarsRepository;
import com.example.CarDealer.Repository.SalesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SalesController {

    @Autowired
    private SalesRespository salesRepo;

    @PostMapping("/buyCar")
    public ResponseEntity<Map<String,String>> buyCar(@RequestBody SalesModel sales) {
        SalesModel saleObj = salesRepo.save(sales);

        Map<String, String> response = new HashMap<>();

        if (saleObj.getCarid() != 0) {
            response.put("Status", "Sales added successfully");
        } else {
            response.put("Status", "Failed");
        }
        return ResponseEntity.ok(response);
    }
}
