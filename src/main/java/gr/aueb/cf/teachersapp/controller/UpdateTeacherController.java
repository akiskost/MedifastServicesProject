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

@WebServlet("/update")
public class UpdateTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("sname");
		
		TeacherDTO oldTeacherDTO = new TeacherDTO();
		oldTeacherDTO.setId(id);
		
		TeacherDTO newTeacherDTO = new TeacherDTO();
		newTeacherDTO.setFname(firstname);
		newTeacherDTO.setSname(lastname);
		
		
		try {
			teacherServ.updateTeacher(oldTeacherDTO, newTeacherDTO);
			request.setAttribute("teacher", newTeacherDTO);
			request.getRequestDispatcher("/jsps/teacherupdated.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
