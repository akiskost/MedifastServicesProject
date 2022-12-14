package com.test.medifastservices.controller;

import com.test.medifastservices.dao.IPatientDAO;
import com.test.medifastservices.dao.PatientDAOImpl;
import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.model.Patient;
import com.test.medifastservices.service.IPatientService;
import com.test.medifastservices.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/newappointment")
public class NewAppointmentController  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IPatientDAO patientDAO = new PatientDAOImpl();
    IPatientService patientServ = new PatientServiceImpl(patientDAO);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String lastname = "";

        // Construct DTO
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setLname(lastname);

        try {
            List<Patient> patients = patientServ.getpatients();
            if (patients != null) {
                request.setAttribute("patients", patients);
                request.getRequestDispatcher("/jsps/newappointment.jsp").forward(request, response);
            } else {
                request.setAttribute("patientsNotFound", true);
                request.getRequestDispatcher("/jsps/newappointment.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
