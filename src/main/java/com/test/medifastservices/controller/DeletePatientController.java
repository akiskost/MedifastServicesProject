package com.test.medifastservices.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.medifastservices.dao.IPatientDAO;
import com.test.medifastservices.dao.PatientDAOImpl;
import com.test.medifastservices.dto.PatientDTO;
import com.test.medifastservices.service.IPatientService;
import com.test.medifastservices.service.PatientServiceImpl;

@WebServlet("/delete")
public class DeletePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IPatientDAO patientDAO = new PatientDAOImpl();
	IPatientService patientServ = new PatientServiceImpl(patientDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");

		
		// Construct DTO
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(id);
		patientDTO.setFname(firstname);
		patientDTO.setLname(lastname);
		
		// Call the service
		try {
			patientServ.deletepatient(patientDTO);
			request.setAttribute("patient", patientDTO);
			request.getRequestDispatcher("/jsps/patientdeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/patients.jsp").forward(request, response);
		}	
	}
}
