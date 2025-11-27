package cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		int year = Integer.parseInt(request.getParameter("year"));

		Book b = new Book(title, author, genre, year);

		BookJdbc bd = new BookJdbc();

		PrintWriter out = response.getWriter();

		boolean status = false;
		try {
			status = bd.books(b);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (status) {
			response.sendRedirect("success.jsp");
		} else {
			out.println("<h2>error!</h2>");
		}
	}
}
