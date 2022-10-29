package com.test.medifastservices.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.medifastservices.model.Patient;

public interface IPatientDAO {
	void insert(Patient patient) throws SQLException;
	void delete(Patient patient) throws SQLException;
	void update(Patient oldPatient, Patient newPatient) throws SQLException;
	List<Patient> getpatientsByLastnane(String lastname) throws SQLException;
	Patient getpatientById(int id) throws SQLException;
}
