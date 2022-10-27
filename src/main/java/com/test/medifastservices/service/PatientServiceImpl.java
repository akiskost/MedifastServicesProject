package com.test.medifastservices.service;

import java.sql.SQLException;
import java.util.List;

import com.test.medifastservices.dao.IPatientDAO;
import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.model.Patient;

public class PatientServiceImpl implements IPatientService {
	
	private final IPatientDAO patientDAO;
	
	public PatientServiceImpl(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Override
	public void insertpatient(PatientDTO patientDTO) throws SQLException {
		
		// Extract dto 
		Patient patient = new Patient();
		patient.setSname(patientDTO.getSname());
		patient.setFname(patientDTO.getFname());
		
		try {
			patientDAO.insert(patient);
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void deletepatient(PatientDTO patientDTO)
			throws SQLException {  // patientNotFoundException
		Patient patientToDelete = new Patient();
		patientToDelete.setId(patientDTO.getId());
		//patientToDelete.setSname(patientDTO.getSname());
		
		try {
			//if (patientDAO.getpatientsByLastnane(patientToDelete.getSname()) != null ) {
			//	patientToDelete.setId(patientDAO.getpatientsByLastnane(patientToDelete.getSname()).get(0).getId());
				patientDAO.delete(patientToDelete);
			//} else {
			//	throw new patientNotFoundException(patientToDelete);
			//}
		} catch (SQLException e) {  // patientNotFoundException |
			// Log the exception
			throw e;
		}
	}

	@Override
	public void updatepatient(PatientDTO oldPatientDTO, PatientDTO newPatientDTO)
			throws SQLException {   // patientNotFoundException
		
		// extract DTO
		Patient patientToUpdate = new Patient();
		//patientToUpdate.setSname(oldpatientDTO.getSname());
		patientToUpdate.setId(oldPatientDTO.getId());
		
		Patient newPatient = new Patient();
		newPatient.setSname(newPatientDTO.getSname());
		newPatient.setFname(newPatientDTO.getFname());
		
		
		// Forward to DAO
		try {
			//if (patientDAO.getpatientsByLastnane(patientToUpdate.getSname()) != null ) {
				//patientToUpdate.setId(patientDAO.getpatientsByLastnane(patientToUpdate.getSname()).get(0).getId());
				patientDAO.update(patientToUpdate, newPatient);
			//} else {
				//throw new patientNotFoundException(patientToUpdate);
			//}
		} catch (SQLException e) { //patientNotFoundException | 
			// Log the exception
			throw e;
		}
	}

	@Override
	public List<Patient> getpatientByLastname(String lastname) throws SQLException {
		try {
			return patientDAO.getpatientsByLastnane(lastname);
		} catch (SQLException e) {
			throw e;
		}
	}

}