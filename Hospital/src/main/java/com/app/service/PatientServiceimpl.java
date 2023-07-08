package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.PatientNotFound;
import com.app.dto.PatientDTO;
import com.app.entities.Patient;
import com.app.entities.hospital;
import com.app.repository.HospitalRepo;
import com.app.repository.PatientRepo;

@Service
@Transactional
public class PatientServiceimpl implements PatientService {

	@Autowired
	private PatientRepo prepo;
	@Autowired
	private ModelMapper mp;
	@Autowired
	private HospitalRepo hr;

	@Override
	public List<Patient> getPatient() {

		return prepo.findAll();
	}

	@Override
	public Patient AddPatient(PatientDTO patient) {

		
		hospital hosp=hr.findById(patient.getHospitalId()).orElseThrow();
		Patient p=mp.map(patient, Patient.class);
		hosp.AddPatient(p);
		return prepo.save(p);
	}
	
	@Override
	public String DeletePatients(long hospID,long patId) {
           hospital hosp=hr.findById(hospID).orElseThrow();
           Patient patient=prepo.findById(patId).orElseThrow();
           
           hosp.DeletePatient(patient);
		
		return "deleted successfully";
	}


}
