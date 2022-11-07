package com.test.medifastservices.service;

import com.test.medifastservices.dao.IAppointmentDAO;
import com.test.medifastservices.dto.AppointmentDTO;
import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.model.Appointment;
import com.test.medifastservices.model.Patient;

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

    @Override
    public void modifyAppointment(AppointmentDTO oldAppointmentDTO, AppointmentDTO newAppointmentDTO)
            throws SQLException {

        // extract DTO
        Appointment appointmentToUpdate = new Appointment();

        appointmentToUpdate.setApid(oldAppointmentDTO.getApid());

        Appointment newAppointment = new Appointment();

        newAppointment.setApid(appointmentToUpdate.getApid());
        newAppointment.setFname(appointmentToUpdate.getFname());
        newAppointment.setLname(appointmentToUpdate.getLname());
        newAppointment.setDate(newAppointmentDTO.getDate());
        newAppointment.setResult(appointmentToUpdate.getResult());

// Forward to DAO
        try {

            appointmentDAO.modifyAppointment(appointmentToUpdate, newAppointment);
        } catch (SQLException e) {
            // Log the exception
            throw e;
        }
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) throws SQLException {

        // Extract dto
        Appointment appointment = new Appointment();

        appointment.setPid(appointmentDTO.getPid());
        appointment.setApid(appointmentDTO.getApid());
        appointment.setFname(appointmentDTO.getFname());
        appointment.setLname(appointmentDTO.getLname());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setExam(appointmentDTO.getExam());
        appointment.setResult(appointmentDTO.getResult());


        try {
            appointmentDAO.addAppointment(appointment);
        } catch (SQLException e) {
            throw e;
        }

    }
}

