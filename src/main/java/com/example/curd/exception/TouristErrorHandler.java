package com.example.curd.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // it is already annotated with @ControllerAdvice & ResponseBody
public class TouristErrorHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails>handleTouristNotFound(TouristNotFoundException tnf){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), tnf.getMessage(),"404-Tourist Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleAllException(Exception e){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(),"Problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

/*
 if we don't catch and handle exception in the business method of rest controller class then Dispatcher Servlet gets the
 propagated exeption and gives to error() of predifined controller called BasicErrorController which is mapped with req-
 uest/error.
 
 The error() method of BasicErrorController class returns ResponseEntity<Map<String, Object>> object having default error
 messages and Dispatcher Servlet convert thoses messages to JSON details and send to client as error json response.
 */

