package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.PatientNotFound;
import com.app.dto.HospitalDTO;
import com.app.entities.Patient;
import com.app.entities.hospital;
import com.app.repository.HospitalRepo;
import com.app.repository.PatientRepo;

@Service
@Transactional
public class HospitalServiceIml implements HospitalService{
	
	@Autowired
	private HospitalRepo hrepo;
	
	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private PatientRepo prepo;

	@Override
	public List<hospital> getAllHospital() {

		return hrepo.findAll();
	}

	@Override
	public String addHospital(HospitalDTO hosp) {
	
		hospital h=mp.map(hosp, hospital.class);
		hospital h1=hrepo.save(h);
		if(h1==null)
			throw new PatientNotFound("data not inserted");
		return "data inserted";
	}

	@Override
	public String UpdateHospital(long id,HospitalDTO hosp) {
		hospital hospi=hrepo.findById(id).orElseThrow();
		hospital h=mp.map(hosp,hospital.class);
		hospi.setLocation(hosp.getLocation());
		hospi.setName(hosp.getName());
		return "data updated";
	}

	
	@Override
	public String DeleteHospital(long id) {
		String msg="not deleted";
		if(hrepo.existsById(id)) {
			hrepo.deleteById(id);
			msg="deleted";
		}
		return msg;
	}
	
	
	
	
	
	
	

}
