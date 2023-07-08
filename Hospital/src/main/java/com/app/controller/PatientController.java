package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientDTO;
import com.app.entities.Patient;
import com.app.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService pServ;
	
	@GetMapping("/")
	public List<Patient> getAllPatient(){
		return pServ.getPatient();
	}

	@PostMapping
	public ResponseEntity<?> addpatient(@RequestBody PatientDTO pat){
		
		return new ResponseEntity(pServ.AddPatient(pat),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable long hospId,@PathVariable long patID) {
		pServ.DeletePatients(hospId, patID);
	}
}
