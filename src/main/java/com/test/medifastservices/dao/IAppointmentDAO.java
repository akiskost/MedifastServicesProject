package com.test.medifastservices.dao;


import java.sql.SQLException;
import java.util.List;
import com.test.medifastservices.model.Appointment;

public interface IAppointmentDAO {
    List<Appointment> getAppointments() throws SQLException;
}
