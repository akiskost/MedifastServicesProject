package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.teachersapp.dao.ITeacherDAO;
import gr.aueb.cf.teachersapp.dao.TeacherDAOImpl;
import gr.aueb.cf.teachersapp.dto.TeacherDTO;
import gr.aueb.cf.teachersapp.service.ITeacherService;
import gr.aueb.cf.teachersapp.service.TeacherServiceImpl;


@WebServlet("/insert")
public class InsertTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		// Construct DTO
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setFname(firstname);
		teacherDTO.setSname(lastname);
		
		// call the service and return feedback/view/data
		try {
			teacherServ.insertTeacher(teacherDTO);
			request.setAttribute("insertedteacher", teacherDTO);
			request.getRequestDispatcher("/jsps/teacherinserted.jsp").forward(request,  response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/teachersmenu.jsp").forward(request, response);
		}	
	}
}
