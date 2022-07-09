package com.example.curd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curd.entity.Tourist;
import com.example.curd.repo.ITouristRepo;

@Service
public class TouristManagementServiceImpl implements ITouristManagementService {
	
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getTId();
		return "Tourist is register having id:: " + idVal;
	}

}
