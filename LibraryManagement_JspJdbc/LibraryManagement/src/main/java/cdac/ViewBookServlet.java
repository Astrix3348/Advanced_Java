package cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		String genre = request.getParameter("genre");
//		int year = Integer.parseInt(request.getParameter("year"));

		PrintWriter out = response.getWriter();

//		Book b = new Book(title, author, genre, year);

		BookJdbc bd = new BookJdbc();
		ResultSet rs = null;

		out.println("-------------");
		try {
			rs = bd.getBooks();
			while (rs.next()) {
				out.println(rs.getString("title"));
				out.println(rs.getString("author"));
				out.println(rs.getString("genre"));
				out.println(rs.getInt("year_published"));
				out.println("-------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
}
