package com.velox.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velox.springboot.entity.Employee;
import com.velox.springboot.entity.User;
import com.velox.springboot.service.UserService;
import com.velox.springboot.utile.ResponseStructure;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/save")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userservice.saveUser(user);
		
	}
	
	@GetMapping("/getAll")
	public ResponseStructure<List<User>> getUser() {
		return userservice.getUser();
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id) {
		return userservice.getUserById(id);
		
	}
	@PutMapping("/updateUserById")
	public ResponseStructure<User> updateUserById(@RequestBody User user,@RequestParam int userId) {
		return userservice.updateUserById(user,userId);
	}
	
	
	@DeleteMapping("/deleteUserById")
	public ResponseEntity<String> deleteUserById(@RequestParam int id)
	{
		return userservice.deleteUserById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		 userservice.deleteAll();
	}
	
	@GetMapping("/getByName")
	public Employee getByName(@RequestParam String name) {
		return userservice.getByName(name);
	}
	
	@GetMapping("/fetchAddress")
	public Employee fetchAddress(@RequestParam String address) {
		return userservice.fetchAddress(address);
	}

}
