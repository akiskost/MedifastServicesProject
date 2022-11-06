package com.test.medifastservices.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.medifastservices.model.Appointment;

import static com.test.medifastservices.dao.dbutil.DBUtil.closeConnection;
import static com.test.medifastservices.dao.dbutil.DBUtil.openConnection;

public class AppointmentDAOImpl implements IAppointmentDAO {

    @Override
    public List<Appointment> getAppointments() throws SQLException {
        PreparedStatement pst = null;
        List<Appointment> appointments = new ArrayList<>();
        ResultSet rs;

        try {

            String sql = "SELECT PEID, patients.FNAME, patients.LNAME, DATE, EXAM_NAME, RESULT FROM patients_exams INNER JOIN patients ON patients_exams.PID=patients.PID INNER JOIN exams ON patients_exams.EID = exams.EID";
            pst = openConnection().prepareStatement(sql);
            rs =  pst.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();

                appointment.setApid(rs.getInt("PEID"));
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
}
