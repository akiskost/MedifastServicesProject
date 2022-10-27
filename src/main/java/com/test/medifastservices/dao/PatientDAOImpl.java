package com.test.medifastservices.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.medifastservices.model.Patient;

import static com.test.medifastservices.dao.dbutil.DBUtil.openConnection;
import static com.test.medifastservices.dao.dbutil.DBUtil.closeConnection;

public class PatientDAOImpl implements IPatientDAO {

	@Override
	public void insert(Patient patient) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO patientS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
					//+ patient.getFname() + "', '" + patient.getSname() + "')";
			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  patient.getFname());
			pst.setString(2,  patient.getSname());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}	
	}

	@Override
	public void delete(Patient patient) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			//String sql = "DELETE FROM patientS WHERE ID = " + patient.getId();
			
			String sql = "DELETE FROM patientS WHERE ID =  ?";
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  patient.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public void update(Patient oldPatient, Patient newPatient) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE patientS SET FIRSTNAME = '" + newPatient.getFname() + "', " + "LASTNAME = '"
					+ newPatient.getSname() + "' WHERE ID = " + oldPatient.getId();
			pst = openConnection().prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public List<Patient> getpatientsByLastnane(String lastname) throws SQLException {
		PreparedStatement pst = null;
		List<Patient> patients = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM patientS WHERE LASTNAME LIKE '" + lastname + "%'";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("ID"));
				patient.setFname(rs.getString("FIRSTNAME"));
				patient.setSname(rs.getString("LASTNAME"));
				
				patients.add(patient);
			}
			
			//if (patients.size() > 0)  return patients; else return null;
			return (patients.size() > 0) ? patients : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public Patient getpatientById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Patient patient = null;
		
		try {
			
			String sql = "SELECT * FROM patientS WHERE ID = " + id;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				patient = new Patient();
				patient.setId(rs.getInt("ID"));
				patient.setFname(rs.getString("FIRSTNAME"));
				patient.setSname(rs.getString("LASTNAME"));
			}
		
			return patient;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

}
