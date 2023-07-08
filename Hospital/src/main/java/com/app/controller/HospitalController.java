package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HospitalDTO;
import com.app.entities.hospital;
import com.app.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hServ;
	
	@Autowired
	private ModelMapper mp;
	
	
	@GetMapping
	public List<hospital> getAllHospital(){
		
		return hServ.getAllHospital();
	}
	
	@PostMapping
	public ResponseEntity<?> AddHospital(@RequestBody HospitalDTO hosp){
		
		return new ResponseEntity<>(hServ.addHospital(hosp),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateHosp(@PathVariable long id,@RequestBody HospitalDTO hosp){
		return new ResponseEntity<>(hServ.UpdateHospital(id, hosp),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public void DeleteHosp(@PathVariable long hospId) {
		hServ.DeleteHospital(hospId);
	}

}
