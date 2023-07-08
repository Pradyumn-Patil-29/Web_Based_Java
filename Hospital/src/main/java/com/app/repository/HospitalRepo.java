package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.hospital;

public interface HospitalRepo extends JpaRepository<hospital, Long> {
	
 Optional<hospital>findById(long id);
 //Optional<hospital>findByHospName(String Name);

}
