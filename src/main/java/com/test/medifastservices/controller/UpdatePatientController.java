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

@WebServlet("/update")
public class UpdatePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IPatientDAO patientDAO = new PatientDAOImpl();
	IPatientService patientServ = new PatientServiceImpl(patientDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("sname");
		
		PatientDTO oldPatientDTO = new PatientDTO();
		oldPatientDTO.setId(id);
		
		PatientDTO newPatientDTO = new PatientDTO();
		newPatientDTO.setFname(firstname);
		newPatientDTO.setSname(lastname);
		
		
		try {
			patientServ.updatepatient(oldPatientDTO, newPatientDTO);
			request.setAttribute("patient", newPatientDTO);
			request.getRequestDispatcher("/jsps/patientupdated.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
