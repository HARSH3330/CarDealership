package com.example.CarDealer.Repository;

import com.example.CarDealer.Models.UserModel;
import com.example.CarDealer.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<UserModel,Long> {

    @Query(value="SELECT `userid`, `email`, `name`, `password`, `phone_no` FROM `user_model` WHERE `email`=?1 AND `password`=?2", nativeQuery = true)
    public List<UserModel> loginValidation(String email, String password);
}