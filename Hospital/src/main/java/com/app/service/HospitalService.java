package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.HospitalDTO;
import com.app.entities.hospital;

public interface HospitalService {

	List<hospital> getAllHospital();
	
	String addHospital(HospitalDTO hosp);
	
	String UpdateHospital(long id,HospitalDTO hosp);
	
	String DeleteHospital(long id);
}
