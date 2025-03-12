package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchCarsRepository extends JpaRepository<CarModel, Long> {
    /*@Query(value = "SELECT `carid`, `colour`, `kms_driven`, `make`, `model`, `no_owners`, `price`, `status`, `year` FROM `car_model` WHERE `carid`=?1 OR ", nativeQuery = true)
    List<CarModel> searchCars(int carid);*/
    @Query(value = "SELECT * FROM car_model WHERE " +
            "(:carid IS NULL OR carid = :carid) AND " +
            "(:make IS NULL OR make LIKE %:make%) AND " +
            "(:model IS NULL OR model LIKE %:model%) AND " +
            "(:colour IS NULL OR colour LIKE %:colour%)",
            nativeQuery = true)
    List<CarModel> searchCars(
            @Param("carid") Integer carid,
            @Param("make") String make,
            @Param("model") String model,
            @Param("colour") String colour
    );
}