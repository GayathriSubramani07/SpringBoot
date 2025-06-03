package com.velox.toy_storeException.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.velox.toy_storeException.controller.ToyController;
import com.velox.toy_storeException.dao.ToyDao;
import com.velox.toy_storeException.exception.IdNotFoundException;
import com.velox.toy_storeException.exception.ToyNotFoundException;
import com.velox.toy_storeException.model.Toy;
import com.velox.toy_storeException.service.response.ResponseStructure;

@Service
public class ToyService {

   
	@Autowired
	 private ToyDao dao;

   
	 
	public Toy getToy(int id) {
		// TODO Auto-generated method stub
		return dao.getToy(id);
	}

	public ResponseEntity<ResponseStructure<Toy>> updateById(Toy t, int id) {
		
		Toy toy = dao.updateById(t,id);
		if(toy !=null)
		{
			ResponseStructure<Toy> structure=new ResponseStructure<>();
			structure.setName("Updated successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setObj(toy);
			return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			throw new IdNotFoundException("Toy is not found");
		}
	}

}
