package cdac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("html/text");
		
		String user = request.getParameter("u_name");
		String passcode = request.getParameter("u_pass");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", user); //storing in the session
		session.setAttribute("password", passcode);
		
		//redirecting to the login page
		response.sendRedirect("login.html");
		
	}
} 
