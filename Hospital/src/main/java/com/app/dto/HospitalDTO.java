package com.app.dto;

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
public class HospitalDTO {
	
//	@Column(length=30)
//	private String Name;
//	@Column(length=30)
//	private String Location;

	private String Name;
	private String Location;


}
