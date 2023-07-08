package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Hospital")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class hospital extends BaseEntity{
	
	@Column(length=30)
	private String Name;
	@Column(length=30)
	private String Location;
	
	@OneToMany(mappedBy = "HospitalId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Patient>PatientList=new ArrayList<>();
	
	public boolean AddPatient(Patient p) {
		PatientList.add(p);
		p.setHospitalId(this);
		return true;
	}
	
	public boolean DeletePatient(Patient p) {
		PatientList.remove(p);
		p.setHospitalId(null);
		return true;
	}

}
