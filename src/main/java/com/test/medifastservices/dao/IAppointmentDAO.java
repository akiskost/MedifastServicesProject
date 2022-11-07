package com.test.medifastservices.dao;


import java.sql.SQLException;
import java.util.List;

import com.test.medifastservices.dto.AppointmentDTO;
import com.test.medifastservices.model.Appointment;

public interface IAppointmentDAO {
    List<Appointment> getAppointments() throws SQLException;
    void modifyAppointment(Appointment oldAppointment, Appointment newAppointment) throws SQLException;
    void addAppointment (Appointment appointment) throws SQLException;
}
