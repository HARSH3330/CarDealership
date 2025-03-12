package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.CarModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UpdateCarsRepository extends JpaRepository <CarModel,Long> {
    @Modifying
    @Transactional
    @Query(value="UPDATE `car_model` SET `colour`=?2,`kms_driven`=?3,`make`=?4,`model`= ?5,`no_owners`=?6,`price`=?7,`status`=?8,`year`=?9 WHERE `carid`=?1", nativeQuery = true)
    public void updateCar(int carid,String colour,double kms_diven,String make,String model,int no_owners,double price,int status,int year);
}
