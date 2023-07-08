package com.app.dto;

import java.time.LocalDate;

import com.app.entities.hospital;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientDTO {

//	@Column
//	private String Name;
//	@Column
//	private LocalDate AdmitDate;
//	@Column
//	private  LocalDate DischargeDate;
//	@Column
//	private String email;
//	@Column
//	private double fees;
//	@Column
//	private String disease;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="HospitalId")
//	private hospital HospitalId;
   
	private String PName;
	private LocalDate AdmitDate;
	private LocalDate DischargeDate;
	private String email;
	private double fees;
	private String disease;
	private Long HospitalId;

}
