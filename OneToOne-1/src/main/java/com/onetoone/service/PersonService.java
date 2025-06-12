package com.onetoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onetoone.dao.PersonDao;
import com.onetoone.entity.Person;
import com.onetoone.response.ResponseStructure;

@Service
public class PersonService {

    
	@Autowired
	private PersonDao persondao;


	public Person savePerson(Person person) {
		
		return persondao.savePerson(person);
	}


	public Person getByPersonId(int id) {
		
		return persondao.getByPersonId(id);
	}


	public Person updatePersonById(Person person, int id) {
		
		return persondao.updatePersonById(person,id);
	}


	public ResponseEntity<ResponseStructure<Person>> deletePersonById(int id) {
		
		Person person= persondao.deletePersonById(id);
		if(person !=null) {
		ResponseStructure<Person> structure= new ResponseStructure<>();
		structure.setMessage("Data Deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setObj(person);
		return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
	}
		else
		{
			ResponseStructure<Person> structure= new ResponseStructure<>();
			structure.setMessage("Data Deleted Unsuccessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setObj(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
		}
	}
}
