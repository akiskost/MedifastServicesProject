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

@WebServlet("/addnewappointment")
public class AddAppointmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IAppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    IAppointmentService appointmentService = new AppointmentServiceImpl(appointmentDAO);


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        // Get the data
        String apid = "0";
        String pid = request.getParameter("pid");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String exam = request.getParameter("exam");
        String date = request.getParameter("date");
        String result = "PENDING";

        // Construct DTO for Appointment info
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setApid(Integer.valueOf(apid));
        appointmentDTO.setPid(Integer.valueOf(pid));
        appointmentDTO.setFname(firstname);
        appointmentDTO.setLname(lastname);
        appointmentDTO.setExam(exam);
        appointmentDTO.setDate(date);
        appointmentDTO.setResult(result);

        // call the service and return feedback/view/data
        try {
            appointmentService.addAppointment(appointmentDTO);
            request.setAttribute("appointmentinserted", appointmentDTO);
            request.getRequestDispatcher("/jsps/appointmentinserted.jsp").forward(request,  response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("sqlError", true);
            request.getRequestDispatcher("/jsps/addnewappointment.jsp").forward(request, response);
        }
    }
}

