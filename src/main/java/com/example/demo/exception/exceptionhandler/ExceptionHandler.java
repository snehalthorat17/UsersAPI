package com.example.demo.exception.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.Response;
import com.example.demo.exception.UserException;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception e){
		
		UserException he = new UserException((long) 400, "User not found");
		return new ResponseEntity<>(he.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}