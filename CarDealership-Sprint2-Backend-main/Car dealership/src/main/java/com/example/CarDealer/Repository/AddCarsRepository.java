package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddCarsRepository extends JpaRepository<CarModel,Long> {

}
