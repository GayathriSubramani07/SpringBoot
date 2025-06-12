package com.onetoone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.onetoone.entity.Person;
import com.onetoone.repo.PersonRepo;

@Repository
public class PersonDao {

	
	@Autowired
	private PersonRepo personrepo;
	
	public Person savePerson(Person person) {
		
		return personrepo.save(person);
	}

	public Person getByPersonId(int id) {
		Optional<Person> optional=personrepo.findById(id);
		if(optional.isPresent())
		{
			Person person=optional.get();
			return person;
		}
		
		return null;
	}

	public Person updatePersonById(Person person, int id) {
		Optional<Person> optional=personrepo.findById(id);
		if(optional.isPresent())
		{
			
			person.setId(id);

		return	personrepo.save(person);
			
		}
		
		return null;
	}

	public Person deletePersonById(int id) {
		
		Optional<Person> optional=personrepo.findById(id);
		if(optional.isPresent())
		{
			Person person=optional.get();
			personrepo.deleteById(id);
			return person;
		}
		
		return null;
	}

	public Person getByPersonaadharId(int id) {
		
		return personrepo.findByAadharCardId(id);
	}

}
