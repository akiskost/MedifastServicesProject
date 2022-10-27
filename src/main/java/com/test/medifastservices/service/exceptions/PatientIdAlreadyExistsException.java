package com.test.medifastservices.service.exceptions;

import com.test.medifastservices.model.Patient;

public class PatientIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PatientIdAlreadyExistsException(Patient patient) {
		super("patient with id = " + patient.getId() + " already exists");
	}
}

