package com.test.medifastservices.service;

import java.sql.SQLException;
import java.util.List;

import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.model.Patient;
import com.test.medifastservices.service.exceptions.PatientIdAlreadyExistsException;
import com.test.medifastservices.service.exceptions.PatientNotFoundException;

public interface IPatientService {
	
	/**
	 * Inserts a {@link Patient} based on the data carried by the {@link PatientDTO}.
	 * 
	 * @param patientDTO
	 * 			DTO object that contains the data
	 * 
	 * @throws PatientIdAlreadyExistsException
	 * 			if any patient, identified by their id, needed to be inserted
	 * 			has already been inserted 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertpatient(PatientDTO patientDTO)
			throws SQLException;
	
	
	
	/**
	 * Removes a {@link Patient} based on the data carried by the {@link PatientDTO}.
	 *  
	 * @param patientDTO
	 * 			DTO object that contains the data (mainly the id)
	 * @throws PatientNotFoundException
	 * 			if any patient, identified by their id, needed to be removed
	 * 			not found 
	 * @throws SQLException
	 * 			if any error happens during SQL delete 
	 */
	void deletepatient(PatientDTO patientDTO)
			throws SQLException; // patientNotFoundException,

	
	
	/**
	 * Updates a {@link Patient} based on the data carried by the {@link PatientDTO}.
	 * 
	 * @param oldPatientDTO
	 * 			DTO object hat contains the data -mainly the id- of the patient
	 * 			that will be updated.
	 * @param newPatientDTO
	 * 			DTO object that contains the data of the new patient.
	 * @throws PatientNotFoundException
	 * 			if any patient, identified by their id, needed to be updated
	 * 			not found 
	 * @throws SQLException
	 * 			if any error happens during SQL update 
	 */			
	void updatepatient(PatientDTO oldPatientDTO, PatientDTO newPatientDTO)
			throws SQLException;  // patientNotFoundException
	
	

	List<Patient> getpatients() throws SQLException;
	
}
