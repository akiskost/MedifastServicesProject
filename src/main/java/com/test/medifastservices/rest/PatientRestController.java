package com.test.medifastservices.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.test.medifastservices.model.Patient;
import com.test.medifastservices.service.IPatientService;
import com.test.medifastservices.service.PatientServiceImpl;
import com.test.medifastservices.dao.IPatientDAO;
import com.test.medifastservices.dao.PatientDAOImpl;

@WebServlet("/patients")
public class PatientRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IPatientDAO patientDAO = new PatientDAOImpl();
	IPatientService patientServ = new PatientServiceImpl(patientDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		String lastname = request.getParameter("lastname").trim();
		
		List<Patient> patients;
		String jsonString;
		Gson gson = new Gson();
		
		try {
			patients = patientServ.getpatients();
			if (patients != null) {
				jsonString = gson.toJson(patients);
				
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
