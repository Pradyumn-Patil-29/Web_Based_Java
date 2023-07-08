package com.app.service;

import java.util.List;

import com.app.dto.PatientDTO;
import com.app.entities.Patient;

public interface PatientService {

	List<Patient>getPatient();
	
	Patient AddPatient(PatientDTO pat);
	
	String DeletePatients(long id,long id1);
	
	//String updatePatient(long id,)
	
}
