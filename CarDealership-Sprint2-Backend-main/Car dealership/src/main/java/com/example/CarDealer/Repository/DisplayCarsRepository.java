package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DisplayCarsRepository extends JpaRepository <CarModel,Long> {

    @Query(value ="SELECT `carid`, `colour`, `kms_driven`, `make`, `model`, `no_owners`, `price`, `status`, `year` FROM `car_model`", nativeQuery = true)
    public List<Map<String,String>> viewAllCars();
}
