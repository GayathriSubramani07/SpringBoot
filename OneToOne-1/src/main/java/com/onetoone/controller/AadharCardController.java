package com.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.entity.AadharCard;
import com.onetoone.service.AadharService;

@RestController
public class AadharCardController {
	@Autowired
	private AadharService aadharservice;
	
	@PostMapping("/saveCard")
	public AadharCard saveAadhar(@RequestBody AadharCard aadharCard,@RequestParam int person_id) {
		return aadharservice.saveAadhar(aadharCard,person_id); 
	}
	
	@GetMapping("/getByCardId")
	public AadharCard getByCardId(@RequestParam int id) {
		return aadharservice.getByCardId(id);
	}
	
	@PutMapping("/updateCardById")
	public AadharCard updateCardById(@RequestParam int id,@RequestBody AadharCard aadharCard) {
		return aadharservice.updateCardById(id,aadharCard);
	}
	
	@DeleteMapping("/deleteCardById")
	public AadharCard deleteCardById(@RequestParam int id) {
		return aadharservice.deleteCardById(id);
	}

}
