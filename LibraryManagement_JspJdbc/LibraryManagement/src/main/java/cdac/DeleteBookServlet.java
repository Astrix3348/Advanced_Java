package cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBookServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("del");
		
		BookJdbc bd = new BookJdbc();
		
		PrintWriter out = response.getWriter();
		
		boolean status = false;
		try {
			status = bd.delBook(title);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status) {
			response.sendRedirect("DelStat.html");
		}
		else {
			out.print("Error Deleting Record");
		}
	}
}
