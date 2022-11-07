package com.test.medifastservices.rest;

import com.google.gson.Gson;
import com.test.medifastservices.dao.AppointmentDAOImpl;
import com.test.medifastservices.dao.IAppointmentDAO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/appointments2")
public class AppointmentsRestController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IAppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    IAppointmentService appointmentService = new AppointmentServiceImpl(appointmentDAO);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Content-Type", "application/json; charset=UTF-8");

        //String lastname = "";

        List<Appointment> appointments;
        String jsonString;
        Gson gson2 = new Gson();

        try {
            appointments = appointmentService.getAppointment();
            if (appointments != null) {
                jsonString = gson2.toJson(appointments);

//				ObjectMapper mapper = new ObjectMapper();
//				jsonString = mapper.writeValueAsString(patients);
                response.getWriter().write(jsonString);
                // JAX-RS -> Jersey / RESTEasy

            } else {
                response.getWriter().write("{}");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
