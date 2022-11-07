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

		response.setContentType("text/html; charset=UTF-8");

		// Display the data
		int pid = Integer.parseInt(request.getParameter("pid"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		Long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
		Long amka = Long.parseLong(request.getParameter("amka"));
		String idno = request.getParameter("idno");

		// Construct DTO
		PatientDTO oldPatientDTO = new PatientDTO();
		oldPatientDTO.setPid(pid);
		
		PatientDTO newPatientDTO = new PatientDTO();
		newPatientDTO.setPid(oldPatientDTO.getPid());
		newPatientDTO.setFname(firstname);
		newPatientDTO.setLname(lastname);
		newPatientDTO.setAddress(address);
		newPatientDTO.setPhonenumber(phonenumber);
		newPatientDTO.setAmka(amka);
		newPatientDTO.setIdno(idno);
		
		
		try {
			patientServ.updatepatient(oldPatientDTO, newPatientDTO);
			request.setAttribute("patient", newPatientDTO);
			request.getRequestDispatcher("/jsps/patientupdated.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
