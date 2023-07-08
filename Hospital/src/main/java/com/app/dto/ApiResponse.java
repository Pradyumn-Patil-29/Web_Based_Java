package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	private String msg;
	private LocalDate date;
	
	public  ApiResponse(String msg) {
		this.msg=msg;
		this.date=LocalDate.now();
	}
}
