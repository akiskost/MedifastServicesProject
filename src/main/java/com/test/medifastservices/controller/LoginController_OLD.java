package com.test.medifastservices.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginold")
public class LoginController_OLD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		// get data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// HTTP SESSION
		HttpSession session=request.getSession();
		session.setAttribute("name",email);


		// call service

		if ( (email.equals("akis@gmail.com")) && (password.equals("123")) ) {
			// return response
			request.getRequestDispatcher("/jsps/home.jsp").forward(request, response);
		} else {
			// return response
			request.setAttribute("error", true);
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
		
		
	}
}
