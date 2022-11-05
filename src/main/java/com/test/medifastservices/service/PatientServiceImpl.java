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
		patient.setPid(patientDTO.getPid());
		patient.setLname(patientDTO.getLname());
		patient.setFname(patientDTO.getFname());
		patient.setAddress(patientDTO.getAddress());
		patient.setPhonenumber(patientDTO.getPhonenumber());
		patient.setAmka(patientDTO.getAmka());
		patient.setIdno(patientDTO.getIdno());
		
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
		patientToDelete.setPid(patientDTO.getPid());
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

		patientToUpdate.setPid(oldPatientDTO.getPid());

		Patient newPatient = new Patient();
		newPatient.setPid(patientToUpdate.getPid());
		newPatient.setFname(newPatientDTO.getFname());
		newPatient.setLname(newPatientDTO.getLname());
		newPatient.setAddress(newPatientDTO.getAddress());
		newPatient.setPhonenumber(newPatientDTO.getPhonenumber());
		newPatient.setAmka(newPatientDTO.getAmka());
		newPatient.setIdno(newPatientDTO.getIdno());

		
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