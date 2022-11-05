package com.test.medifastservices.service;

import com.test.medifastservices.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface IAppointmentService {

    List<Appointment> getAppointment() throws SQLException;

}
