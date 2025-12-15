package cdac;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("u_name");
		String upass = request.getParameter("u_pass");

		if (uname.equals("aakash") && upass.equals("1234")) {
			HttpSession session = request.getSession(); //creating a new session
			session.setAttribute("username", uname);
			
			response.sendRedirect("add.html");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("Invalid Login!!");
		}
	}

}
