package com.test.medifastservices.controller;

import com.test.medifastservices.dao.UserDAOImpl;
import com.test.medifastservices.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.medifastservices.dao.IUserDAO;
import com.test.medifastservices.dao.UserDAOImpl;
import com.test.medifastservices.dto.UserDTO;
import com.test.medifastservices.model.User;
import com.test.medifastservices.service.IPatientService;
import com.test.medifastservices.service.IUserService;
import com.test.medifastservices.service.PatientServiceImpl;
import com.test.medifastservices.service.UserServiceImpl;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		// get data
		String email = request.getParameter("email");
		String password = request.getParameter("password");

//		// Construct DTO
//		UserDTO userDTO = new UserDTO();
//		userDTO.setEmail(email);
//		userDTO.setPassword(password);
		IUserDAO userDAO = new UserDAOImpl();
		//IUserService userService = new UserServiceImpl(userDAO);

		try {
			User user = userDAO.checkLogin(email,password);
			//userService.checkedLogin(userDTO);

			System.out.println("LOGIN CONTROLLER USER");
			System.out.println(user);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("/jsps/home.jsp").forward(request, response);
			} else {
				String message = "Invalid email/password";
				request.setAttribute("message", message);
			}


		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
		}
	}
}