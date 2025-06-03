package com.velox.springboot_validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.velox.springboot_validation.dao.LetterDao;
import com.velox.springboot_validation.entity.Letter;
import com.velox.springboot_validation.exception.DataSaveException;
import com.velox.springboot_validation.response.ResponseStructure;

@Service
public class LetterService {
	
	@Autowired
	private LetterDao Dao;

	public ResponseEntity<ResponseStructure<Letter>> saveLetter(Letter letter) {
	    Letter l = Dao.saveLetter(letter);
	    ResponseStructure<Letter> response = new ResponseStructure<>();

	    if (l != null) {
	        response.setStatus(HttpStatus.ACCEPTED.value());
	        response.setMessage("Data saved successfully");
	        response.setData(l);
	        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	    } else {
	        throw new DataSaveException("Failed to save the letter data.");
	    }
	}

}
