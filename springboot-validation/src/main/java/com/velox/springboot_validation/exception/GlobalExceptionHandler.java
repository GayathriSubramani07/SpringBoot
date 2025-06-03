package com.velox.springboot_validation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
//    Instant of map i can able to use ResponseEntity also
    @ExceptionHandler(DataSaveException.class)
    public ResponseEntity<Map<String, String>> handleDataSaveException(DataSaveException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Data not saved successfully");
        response.put("details", e.getMessage()); // message you passed in the throw
        response.put("status", HttpStatus.NOT_ACCEPTABLE.toString()); // 406 NOT_ACCEPTABLE
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
    
    
	/*
	 * @ExceptionHandler(DataSaveException.class) public
	 * ResponseEntity<ResponseStructure<String>>
	 * handleDataSaveException(DataSaveException e) { ResponseStructure<String>
	 * response = new ResponseStructure<>();
	 * response.setMessage("Data not saved successfully");
	 * response.setData(e.getMessage()); // The custom message passed during
	 * exception response.setStatus(HttpStatus.NOT_ACCEPTABLE.value()); // 406
	 * 
	 * return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE); }
	 */


}
