package com.velox.toy_storeException.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.velox.toy_storeException.exception.ToyNotFoundException;
import com.velox.toy_storeException.model.Toy;
import com.velox.toy_storeException.repository.ToyRepository;
import com.velox.toy_storeException.service.response.ResponseStructure;

@Repository
public class ToyDao {
	@Autowired
	private ToyRepository repo;
	
	public Toy getToy(int id) {
		
		return repo.findById(id).orElseThrow(() -> new ToyNotFoundException("Toy with ID = "+id+" is not found"));
}

	public Toy updateById(Toy t, int id) {
	Optional<Toy> optional	= repo.findById(id);
	if(optional.isPresent())
	{
		t.setId(id);
		return repo.save(t);
	}
		
		return null;
	}
}
