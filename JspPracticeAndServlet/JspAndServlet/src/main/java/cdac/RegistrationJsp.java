package cdac;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationJsp extends HttpServlet {
	ArrayList<Student1> students = new ArrayList<>();


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter("s_name");

		int prn = (Integer.parseInt(request.getParameter("s_prn")));
		
		String email = request.getParameter("s_email");

		Student1 s = new Student1(name, prn, email);

		students.add(s);

		request.setAttribute("theObject", students);

		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);

	}

}
