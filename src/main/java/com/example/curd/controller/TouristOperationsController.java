package com.example.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.entity.Tourist;
import com.example.curd.service.ITouristManagementService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	
	@Autowired
	private ITouristManagementService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		// use service
		try {
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in tourist endrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
