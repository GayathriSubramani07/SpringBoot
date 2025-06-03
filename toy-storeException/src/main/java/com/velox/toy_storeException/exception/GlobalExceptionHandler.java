package com.velox.toy_storeException.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.velox.toy_storeException.service.response.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ToyNotFoundException.class)
    public ResponseEntity<String> handleToyNotFoundException(ToyNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFoundException e){
    	ResponseStructure<String> structure =new ResponseStructure<>();
    	structure.setName("id is not found");
    	structure.setStatus(HttpStatus.NOT_FOUND.value());
    	structure.setObj(e.getMessage());
    	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
    }
}
