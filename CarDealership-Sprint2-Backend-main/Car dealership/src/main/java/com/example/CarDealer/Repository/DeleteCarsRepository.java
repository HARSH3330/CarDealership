package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.CarModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DeleteCarsRepository extends JpaRepository<CarModel,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE car_model c SET c.status = 0 WHERE c.carid = ?1",nativeQuery = true)
    void deleteCar(int carId);
}
