package com.app.dto;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString //only fro debuuging

//P.L Validations
public class AuthRequestDTO {
	
	@NotBlank(message="Email cant be blank")
	private String email;
	@NotBlank(message="password is required")
	private String password;
}
