package com.test.medifastservices.service.exceptions;

import com.test.medifastservices.model.Patient;

public class PatientNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(Patient patient) {
		super("patient with id = " + patient.getPid() + " was not found");
	}
}
