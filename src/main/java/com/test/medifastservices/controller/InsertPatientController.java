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


@WebServlet("/insert")
public class InsertPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IPatientDAO patientDAO = new PatientDAOImpl();
	IPatientService patientServ = new PatientServiceImpl(patientDAO);
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		// Construct DTO
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setFname(firstname);
		patientDTO.setSname(lastname);
		
		// call the service and return feedback/view/data
		try {
			patientServ.insertpatient(patientDTO);
			request.setAttribute("insertedpatient", patientDTO);
			request.getRequestDispatcher("/jsps/patientinserted.jsp").forward(request,  response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/patientsmenu.jsp").forward(request, response);
		}	
	}
}
