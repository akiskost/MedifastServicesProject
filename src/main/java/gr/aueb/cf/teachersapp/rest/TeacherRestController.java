package gr.aueb.cf.teachersapp.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import gr.aueb.cf.teachersapp.dao.ITeacherDAO;
import gr.aueb.cf.teachersapp.dao.TeacherDAOImpl;
import gr.aueb.cf.teachersapp.model.Teacher;
import gr.aueb.cf.teachersapp.service.ITeacherService;
import gr.aueb.cf.teachersapp.service.TeacherServiceImpl;

@WebServlet("/teachers")
public class TeacherRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		String lastname = request.getParameter("lastname").trim();
		
		List<Teacher> teachers = new ArrayList<>();
		String jsonString;
		Gson gson = new Gson();
		
		try {
			teachers = teacherServ.getTeacherByLastname(lastname);
			if (teachers != null) {
				jsonString = gson.toJson(teachers);
				
//				ObjectMapper mapper = new ObjectMapper();
//				jsonString = mapper.writeValueAsString(teachers);
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
