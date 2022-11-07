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
		try {
				patientDAO.delete(patientToDelete);

		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void updatepatient(PatientDTO oldPatientDTO, PatientDTO newPatientDTO)
			throws SQLException {
		
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
				patientDAO.update(patientToUpdate, newPatient);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Patient> getpatients() throws SQLException {
		try {
			return patientDAO.getPatients();
		} catch (SQLException e) {
			throw e;
		}
	}

}