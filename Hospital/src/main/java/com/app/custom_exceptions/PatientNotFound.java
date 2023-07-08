package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class PatientNotFound extends RuntimeException {
	public PatientNotFound(String msg) {
		super(msg);
	}

}
