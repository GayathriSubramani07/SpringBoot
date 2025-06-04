package com.velox.customevalidation.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.customevalidation.entity.User;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User data is valid and saved successfully");
    }
}

