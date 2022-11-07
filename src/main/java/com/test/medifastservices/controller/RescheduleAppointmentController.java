package com.test.medifastservices.controller;

import com.test.medifastservices.dao.AppointmentDAOImpl;
import com.test.medifastservices.dao.IAppointmentDAO;
import com.test.medifastservices.dao.IPatientDAO;
import com.test.medifastservices.dao.PatientDAOImpl;
import com.test.medifastservices.dto.AppointmentDTO;
import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.service.AppointmentServiceImpl;
import com.test.medifastservices.service.IAppointmentService;
import com.test.medifastservices.service.IPatientService;
import com.test.medifastservices.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/reschedule")
public class RescheduleAppointmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IAppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    IAppointmentService appointmentService = new AppointmentServiceImpl(appointmentDAO);


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        // Get the data
        int apid = Integer.parseInt(request.getParameter("apid"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String date = request.getParameter("date");
        String exam = request.getParameter("exam");
        String result = request.getParameter("result");

        // Construct DTO
        AppointmentDTO oldAppointmentDTO = new AppointmentDTO();
        oldAppointmentDTO.setApid(apid);

        AppointmentDTO newAppointmentDTO = new AppointmentDTO();
        newAppointmentDTO.setApid(apid);
        newAppointmentDTO.setFname(firstname);
        newAppointmentDTO.setLname(lastname);
        newAppointmentDTO.setDate(date);
        newAppointmentDTO.setExam(exam);
        newAppointmentDTO.setResult(result);


        // call the service and return feedback/view/data
        try {
            appointmentService.modifyAppointment(oldAppointmentDTO, newAppointmentDTO);
            request.setAttribute("appointment", newAppointmentDTO);
            request.getRequestDispatcher("/jsps/appointmentrescheduled.jsp").forward(request,  response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("sqlError", true);
        }
    }
}

