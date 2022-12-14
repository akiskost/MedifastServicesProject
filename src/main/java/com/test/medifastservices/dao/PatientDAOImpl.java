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

		//PREPARED STATEMENTS
		PreparedStatement pst = null;
		PreparedStatement pos;
//		PreparedStatement npid = null;

		try {

			String sql = "INSERT INTO patients (PID, FNAME, LNAME, ADDRESS, PHONENUMBER, AMKA, ID_NO) VALUES (?, ?, ?, ?, ?, ?, ?)";
			pst = openConnection().prepareStatement(sql);

			String tablepos = "SELECT * FROM patients";
			pos = openConnection().prepareStatement(tablepos);

			ResultSet rs = pos.executeQuery(tablepos);
			int curRowNo = rs.getRow();

			pst.setLong(1,curRowNo);
			pst.setString(2,  patient.getFname());
			pst.setString(3,  patient.getLname());
			pst.setString(4,  patient.getAddress());
			pst.setLong(5,  patient.getPhonenumber());
			pst.setLong(6,  patient.getAmka());
			pst.setString(7,  patient.getIdno());

			pst.executeUpdate();
			curRowNo = 0;

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
			String sql = "DELETE FROM patients WHERE PID = " + patient.getPid();
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
	public void update(Patient oldPatient, Patient newPatient) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE patients SET FNAME = '" + newPatient.getFname() +
					"'," + " " + "LNAME = '"  + newPatient.getLname() +
					"'," + " " + "ADDRESS = '"  + newPatient.getAddress() +
					"'," + " " + "PHONENUMBER = '"  + newPatient.getPhonenumber() +
					"'," + " " + "AMKA = '"  + newPatient.getAmka() +
					"'," + " " + "ID_NO = '"  + newPatient.getIdno() +
					"' WHERE PID = " + oldPatient.getPid();

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
	public List<Patient> getPatients() throws SQLException {
		PreparedStatement pst = null;
		List<Patient> patients = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT PID, FNAME, LNAME, ADDRESS, PHONENUMBER, AMKA, ID_NO FROM patients";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {

				Patient patient = new Patient();

				patient.setPid(rs.getInt("PID"));
				patient.setFname(rs.getString("FNAME"));
				patient.setLname(rs.getString("LNAME"));
				patient.setAddress(rs.getString("ADDRESS"));
				patient.setPhonenumber(rs.getLong("PHONENUMBER"));
				patient.setAmka(rs.getLong("AMKA"));
				patient.setIdno(rs.getString("ID_NO"));
				
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
	public Patient getpatientById(int pid) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Patient patient = null;
		
		try {
			
			String sql = "SELECT * FROM patients WHERE PID = " + pid;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				patient = new Patient();
				patient.setPid(rs.getInt("PID"));
				patient.setFname(rs.getString("FNAME"));
				patient.setLname(rs.getString("LNAME"));
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
