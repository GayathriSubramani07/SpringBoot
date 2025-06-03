package com.velox.toy_storeException.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.velox.toy_storeException.model.Toy;
import com.velox.toy_storeException.service.ToyService;
import com.velox.toy_storeException.service.response.ResponseStructure;

@RestController
public class ToyController {
	@Autowired
	private ToyService ser;
	
	@GetMapping("/gettoy/{id}")
	private Toy getToy(@PathVariable int id) {
		return ser.getToy(id);
	}
	
	@PutMapping("/update")
	private ResponseEntity<ResponseStructure<Toy>> updateById(@RequestBody Toy t,@RequestParam int  id){
		return ser.updateById(t,id);
		
	}

}
