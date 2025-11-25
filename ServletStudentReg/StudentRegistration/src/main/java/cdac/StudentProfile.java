package cdac;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentProfile extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sid = request.getParameter("s_id");
		int ss_id = Integer.parseInt(sid);
		String sName = request.getParameter("s_name");
		String sEmail = request.getParameter("s_email");
		String sGender = request.getParameter("s_gender");
		String sCourse = request.getParameter("course");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Id: " + ss_id + "</h2>");
		out.println("<h2>Name: " + sName + "</h2>");
		out.println("<h2>Email: " + sEmail + "</h2>");
		out.println("<h2>Gender: " + sGender + "</h2>");
		out.print("<h2>Course: " + sCourse + "</h2>");
		
	}
}
