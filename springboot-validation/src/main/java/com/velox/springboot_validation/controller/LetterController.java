package com.velox.springboot_validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.velox.springboot_validation.entity.Letter;
import com.velox.springboot_validation.response.ResponseStructure;
import com.velox.springboot_validation.service.LetterService;

@RestController
public class LetterController {
	@Autowired
	private LetterService letterser;
	
	@PostMapping("/send")
    public ResponseEntity<ResponseStructure<Letter>> saveLetter(@Validated @RequestBody Letter letter) {
       return letterser.saveLetter(letter);
    }

}
