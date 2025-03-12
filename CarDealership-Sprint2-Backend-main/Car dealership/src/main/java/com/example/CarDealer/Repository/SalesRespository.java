package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRespository extends JpaRepository<SalesModel,Long> {
}
