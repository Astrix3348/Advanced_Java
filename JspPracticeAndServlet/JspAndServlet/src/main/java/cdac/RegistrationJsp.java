package cdac;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationJsp extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter("s_name");
		int prn = Integer.parseInt(request.getParameter("s_prn"));
		String email = request.getParameter("s_email");

		request.setAttribute("sName", name);
		request.setAttribute("sPrn", prn);
		request.setAttribute("sEmail", email);

		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);

	}

}
