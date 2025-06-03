package com.velox.springboot_validation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.velox.springboot_validation.controller.LetterController;
import com.velox.springboot_validation.entity.Letter;
import com.velox.springboot_validation.repo.LetterRepo;

@Repository
public class LetterDao {

    

	@Autowired
	private LetterRepo repo;

    
	public Letter saveLetter(Letter letter) {
		
		Letter l= repo.save(letter);
		return l;
	}

}
