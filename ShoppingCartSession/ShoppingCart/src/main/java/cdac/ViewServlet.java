package cdac;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession(false);

		// validating login
		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect("login.html");
			return;
		}

		// forward to the JSP
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}
}
