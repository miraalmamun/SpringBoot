package com.jpa.practice.controller;

import com.jpa.practice.model.Users;
import com.jpa.practice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UserRequest request) {
        Users user = userService.createUser(request.getName(), request.getAddress());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<Users>> getUsersByCity(@RequestParam String city) {
        List<Users> users = userService.getUsersByCity(city);
        return ResponseEntity.ok(users);
    }
}

class UserRequest {
    private String name;
    private String address;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //Endpoint: POST /api/users

    //    {
    //        "name": "John Doe",
    //            "address": "{\"street\": \"123 Elm St\", \"city\": \"New York\", \"zipCode\": \"10001\"}"
    //    }

      /*
                   {
              "id": 1,
              "name": "John Doe",
              "address": "{\"street\": \"123 Elm St\", \"city\": \"New York\", \"zipCode\": \"10001\"}"
            }

       */

    //Endpoint: GET /api/users/by-city?city=New York

}
