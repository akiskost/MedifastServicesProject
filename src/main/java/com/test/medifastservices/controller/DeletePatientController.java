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

		// Display the data
		long pid = Long.parseLong(request.getParameter("pid"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
		int amka = Integer.parseInt(request.getParameter("amka"));
		String idno = request.getParameter("idno");

		// Construct DTO
		PatientDTO patientDTO = new PatientDTO();

		patientDTO.setPid(Math.toIntExact(pid));
		patientDTO.setFname(firstname);
		patientDTO.setLname(lastname);
		patientDTO.setAddress(address);
		patientDTO.setPhonenumber(phonenumber);
		patientDTO.setAmka(amka);
		patientDTO.setIdno(idno);
		
		// Call the service
		try {
			patientServ.deletepatient(patientDTO);
			request.setAttribute("patient", patientDTO);
			request.getRequestDispatcher("/jsps/patientdeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/home.jsp").forward(request, response);
		}	
	}
}
