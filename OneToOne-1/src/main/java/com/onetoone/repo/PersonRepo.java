package com.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onetoone.entity.Person;

public interface PersonRepo extends  JpaRepository<Person, Integer>{

	@Query("SELECT p FROM Person p WHERE p.aadhar_id.id = :id")
	Person findByAadharCardId(@Param("id") int id);


}
