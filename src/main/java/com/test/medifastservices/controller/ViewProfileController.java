package com.test.medifastservices.controller;

import com.test.medifastservices.dao.AppointmentDAOImpl;
import com.test.medifastservices.dao.IAppointmentDAO;
import com.test.medifastservices.dto.AppointmentDTO;
import com.test.medifastservices.model.Appointment;
import com.test.medifastservices.service.AppointmentServiceImpl;
import com.test.medifastservices.service.IAppointmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/view")
public class ViewProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IAppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    IAppointmentService appointmentService = new AppointmentServiceImpl(appointmentDAO);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        int pid = Integer.parseInt(request.getParameter("pid"));

        try {

            List<Appointment> appointments = appointmentService.getAppointmentByApid(pid);

            if (appointments != null) {

                request.setAttribute("appointments", appointments);
                request.getRequestDispatcher("jsps/patientsprofile.jsp").forward(request, response);
            } else {
                request.setAttribute("appointmentNotFound", true);
                request.getRequestDispatcher("jsps/patientsprofile.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

