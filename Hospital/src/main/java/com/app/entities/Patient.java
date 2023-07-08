package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Patient extends BaseEntity {
	@Column
	private String PName;
	@Column
	private LocalDate AdmitDate;
	@Column
	private  LocalDate DischargeDate;
	@Column
	private String email;
	@Column
	private double fees;
	@Column
	private String disease;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="HospitalId")
	private hospital HospitalId;
	
	

}
