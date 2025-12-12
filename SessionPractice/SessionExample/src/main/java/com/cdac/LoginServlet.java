package com.cdac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		// validation (you can validate from database )
		if (uname.equals("admin") && pass.equals("1234")) {
			HttpSession session = request.getSession(); // creating a session
			session.setAttribute("username", uname);

			response.sendRedirect("register.html");
		} else {
			response.getWriter().print("invalid Login... <a href='login.html'>Try Again</a>");
		}
	}
}
