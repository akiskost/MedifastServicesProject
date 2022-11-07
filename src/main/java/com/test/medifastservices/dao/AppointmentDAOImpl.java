package com.test.medifastservices.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.medifastservices.model.Appointment;
import com.test.medifastservices.model.Patient;

import javax.servlet.http.HttpSession;

import static com.test.medifastservices.dao.dbutil.DBUtil.closeConnection;
import static com.test.medifastservices.dao.dbutil.DBUtil.openConnection;

public class AppointmentDAOImpl implements IAppointmentDAO {

    @Override
    public List<Appointment> getAppointments() throws SQLException {
        PreparedStatement pst = null;
        List<Appointment> appointments = new ArrayList<>();
        ResultSet rs;

        try {

            String sql = "SELECT * FROM appointmentview";
            pst = openConnection().prepareStatement(sql);
            rs =  pst.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();

                appointment.setApid(rs.getInt("PEID"));
                appointment.setPid(rs.getInt("PID"));
                appointment.setFname(rs.getString("FNAME"));
                appointment.setLname(rs.getString("LNAME"));
                appointment.setDate(rs.getString("DATE"));
                appointment.setExam(rs.getString("EXAM_NAME"));
                appointment.setResult(rs.getString("RESULT"));

                appointments.add(appointment);
            }

            return (appointments.size() > 0) ? appointments : null;

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) pst.close();
            if (openConnection() != null) closeConnection();
        }
    }

    @Override
    public List<Appointment> getAppointmentByApid(int pid) throws SQLException {
        PreparedStatement pst = null;
        List<Appointment> appointments = new ArrayList<>();
        ResultSet rs;

        try {

            String sql = "SELECT * FROM appointmentview WHERE PID LIKE'" + pid + "%'";
            pst = openConnection().prepareStatement(sql);
            rs =  pst.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();

                appointment.setApid(rs.getInt("PEID"));
                appointment.setPid(rs.getInt("PID"));
                appointment.setFname(rs.getString("FNAME"));
                appointment.setLname(rs.getString("LNAME"));
                appointment.setDate(rs.getString("DATE"));
                appointment.setExam(rs.getString("EXAM_NAME"));
                appointment.setResult(rs.getString("RESULT"));

                appointments.add(appointment);
            }

            return (appointments.size() > 0) ? appointments : null;

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) pst.close();
            if (openConnection() != null) closeConnection();
        }
    }


    @Override
    public void modifyAppointment(Appointment oldAppointment, Appointment newAppointment) throws SQLException {
        PreparedStatement pst = null;

        try {

            String sql = "UPDATE patients_exams SET date = '" + newAppointment.getDate() + "' WHERE PEID = " + oldAppointment.getApid();

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
    public void addAppointment(Appointment appointment) throws SQLException {

        //PREPARED STATEMENT
        PreparedStatement pst = null;

        try {

            String sql = "INSERT INTO patients_exams (PEID, PID, DATE, EID, RESULT)  VALUES (?, ?, ?, ?, ?)";
            pst = openConnection().prepareStatement(sql);

            pst.setInt(1,appointment.getApid());
            pst.setInt(2, appointment.getPid());
            pst.setString(3,  appointment.getDate());
            pst.setString(4,  appointment.getExam());
            pst.setString(5,  appointment.getResult());


            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) pst.close();
            if (openConnection() != null) closeConnection();
        }
    }
}
