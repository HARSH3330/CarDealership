package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.UserModel;
import com.example.CarDealer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
//@Validated
public class UserController {

    @Autowired
    private UserRepository userRepo;

    public static final Map<String,String> tokenStore =new HashMap<>();

    @PostMapping("/signUp")
    /*public ResponseEntity<Map<String, String>> signUp(@Validated @RequestBody UserModel user, BindingResult result) {
        Map<String, String> response = new HashMap<>();

        // Check if there are validation errors
        if (result.hasErrors()) {
            for (var error : result.getFieldErrors()) {
                response.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response); // Return 400 Bad Request with error messages
        }*/
    public ResponseEntity<Map<String,String>> signUp(@RequestBody UserModel user){
        UserModel userObj = userRepo.save(user);

        Map<String,String> response = new HashMap<>();

        if(userObj.getUserid() != 0){
            response.put("Status","Signup success");
            response.put("User id",String.valueOf(userObj.getUserid()));
            response.put("Name",String.valueOf(userObj.getName()));

        }
        else{
            response.put("Status","Signup failed!");
        }
        return ResponseEntity.ok(response);
    }
    /*@PostMapping("/signIn")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody UserModel user){
        List<UserModel> userObj = userRepo.loginValidation(user.getEmail(),user.getPassword());

        Map<String,String> response = new HashMap<>();

        if(userObj.size() > 0){
            String token = UUID.randomUUID().toString();
            tokenStore.put(token, user.getName());

            UserModel loggedInUser = userObj.get(0); // Get logged-in user
            String role = loggedInUser.getRole(); // Fetch user role

            response.put("Status","Sign in success");
            response.put("Token", token);
            response.put("User Id",String.valueOf(userObj.get(0).getUserid()));
            response.put("Name",String.valueOf(userObj.get(0).getName()));

            response.put("role", role); // Return user role
        }
        else{
            response.put("Status","Sign in failed");
        }
        return ResponseEntity.ok(response);
    }*/
    @PostMapping("/signIn")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserModel user) {
        List<UserModel> userObj = userRepo.loginValidation(user.getEmail(), user.getPassword());
        Map<String, String> response = new HashMap<>();

        if (!userObj.isEmpty()) {
            UserModel loggedInUser = userObj.get(0);
            String token = UUID.randomUUID().toString();
            tokenStore.put(token, loggedInUser.getEmail());

            response.put("Status", "Sign in success");
            response.put("Token", token);
            response.put("User Id", String.valueOf(loggedInUser.getUserid()));
            response.put("Name", loggedInUser.getName());
            response.put("Role", loggedInUser.getRole());  // Ensure role is returned
        } else {
            response.put("Status", "Sign in failed");
        }
        return ResponseEntity.ok(response);
    }

}
