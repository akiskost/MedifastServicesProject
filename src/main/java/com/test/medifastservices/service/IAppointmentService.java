package com.test.medifastservices.service;

import com.test.medifastservices.dto.AppointmentDTO;
import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface IAppointmentService {

    List<Appointment> getAppointment() throws SQLException;

    List<Appointment> getAppointmentByApid(int pid) throws SQLException;

    void modifyAppointment(AppointmentDTO oldAppointmentDTO, AppointmentDTO newAppointmentDTO)
            throws SQLException;  // patientNotFoundException

    void addAppointment (AppointmentDTO appointmentDTO)
            throws SQLException;

}
