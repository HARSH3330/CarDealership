package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.CarModel;
import com.example.CarDealer.Repository.SearchCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SearchCarsController {

    @Autowired
    private SearchCarsRepository searchCarsRepo;

    @PostMapping("/searchCar")
    public ResponseEntity<List<CarModel>> search(@RequestBody CarModel car)
    {
        /*List<CarModel> data= searchCarsRepo.searchCars(car.getCarid());
        return ResponseEntity.ok(data);*/
        List<CarModel> results = searchCarsRepo.searchCars(
                car.getCarid() == 0 ? null : car.getCarid(),
                (car.getMake() == null || car.getMake().isEmpty()) ? null : car.getMake(),
                (car.getModel() == null || car.getModel().isEmpty()) ? null : car.getModel(),
                (car.getColour() == null || car.getColour().isEmpty()) ? null : car.getColour()
        );
        return ResponseEntity.ok(results);
    }
}
