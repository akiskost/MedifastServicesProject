package com.test.medifastservices.service;

import com.test.medifastservices.dao.IAppointmentDAO;
import com.test.medifastservices.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentDAO appointmentDAO;

    public AppointmentServiceImpl(IAppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public List<Appointment> getAppointment() throws SQLException {
        try {
            return appointmentDAO.getAppointments();
        } catch (SQLException e) {
            throw e;
        }
    }
}
