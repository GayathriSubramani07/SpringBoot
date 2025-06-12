package com.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.entity.Person;
import com.onetoone.response.ResponseStructure;
import com.onetoone.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personservice;
	
	@PostMapping("/saveperson")
	public Person savePerson(@RequestBody Person person) {
		return personservice.savePerson(person);
	}
	
	@GetMapping("/getByPersonId")
	public Person getByPersonId(@RequestParam int id) {
		return personservice.getByPersonId(id);
	}
	
	@PutMapping("/updatePersonById")
	public Person updatePersonById(@RequestBody Person person, @RequestParam int id) {
		return personservice.updatePersonById(person,id);
	}
	
	@DeleteMapping("/deletePersonById")
	public ResponseEntity<ResponseStructure<Person>> deletePersonById(@RequestParam int id){
		return personservice.deletePersonById(id);
	}

}
