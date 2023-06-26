package com.app.execption_handler;


import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;

//how to tell Sc,followiing class is spring bean,containing common advice to all rest
//controller,regarding centralized exc handling
/*
@RestController //controller+ responsebody
we can use it in rest webservices*/
/*
@RestControllerAdvice =@ControllerAdvice+@ResponseBody
added impl on
   */
@RestControllerAdvice
public class GlobalExeptionHandler {
	//can contain single/multiple exc handling methods
	//how to tell SC,follwing method:exc handling method
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<?>handleMethodArguemntNotValidExeption(MethodArgumentNotValidException e){
		
		//convert List<FieldError>--->map:fieldname,def mesg
		Map<String,String> map=e.getFieldErrors()
				                 .stream()
				                 .collect(Collectors.toMap(f->f.getField(),f->f.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
//	public ResponseEntity<?> handleMethodArguemntNotValidExeption(MethodArgumentNotValidException e) {
//
//		// convert List<FieldError>--->map:fieldname,def mesg
//		Map<String, String> map = e.getFieldErrors()
//				                   .stream()
//				                   .collect(Collectors.toMap(f -> f.getField(), f -> f.getDefaultMessage()));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
//	}

	//List<FieldError>getFieldErrors()
	//API of FieldError class: getField():Field: field name with err,
	//getDefaultMessage: err mesg
	
	
	//add another exc handling method to handle resource not found exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?>handlerResourceNotFoundException(ResourceNotFoundException e)
	{
		System.out.println("handle res not found"+e);
		
		return ResponseEntity
			   .status(HttpStatus.NOT_FOUND)
			   .body(new ApiResponse(e.getMessage()));
	}
	
	//catch-all: H.W

}
