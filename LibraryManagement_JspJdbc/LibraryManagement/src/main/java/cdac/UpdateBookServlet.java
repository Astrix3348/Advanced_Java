package cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBookServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("u_title");
		String author = request.getParameter("u_author");
		String genre = request.getParameter("u_genre");
		int year = Integer.parseInt(request.getParameter("u_year"));
		
		Book b = new Book(title, author, genre, year);
		
		BookJdbc bd = new BookJdbc();
		
		PrintWriter out = response.getWriter();
		
		boolean stat = false;
		
		try {
			stat = bd.updateBook(b);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stat) {
			response.sendRedirect("success.jsp");
		}
		else {
			out.print("Error Updating!!");
		}
	}
}
