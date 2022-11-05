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


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		String pid = request.getParameter("pid").trim();
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		String address = request.getParameter("address").trim();
		String phonenumber = request.getParameter("phonenumber").trim();
		String amka = request.getParameter("amka").trim();
		String idno = request.getParameter("idno").trim();
		
		// Construct DTO
		PatientDTO patientDTO = new PatientDTO();

		patientDTO.setPid(Integer.valueOf(pid));
		patientDTO.setFname(firstname);
		patientDTO.setLname(lastname);
		patientDTO.setAddress(address);
		patientDTO.setPhonenumber(Integer.valueOf(phonenumber));
		patientDTO.setAmka(Integer.valueOf(amka));
		patientDTO.setIdno(idno);

		
		// call the service and return feedback/view/data
		try {
			patientServ.insertpatient(patientDTO);
			request.setAttribute("insertedpatient", patientDTO);
			request.getRequestDispatcher("/jsps/patientinserted.jsp").forward(request,  response);

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/newpatient.jsp").forward(request, response);
		}
	}
}
