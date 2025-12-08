package cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookJdbc {
	Connection con;
	
	public void accessConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "");

	}
	
	
	public boolean books(Book b) throws ClassNotFoundException, SQLException {
		accessConnection();
		
		String insertBook = "insert into books(title, author, genre, year_published) values(?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(insertBook);

		pmt.setString(1, b.title);
		pmt.setString(2, b.author);
		pmt.setString(3, b.genre);
		pmt.setInt(4, b.year);

		int rows = pmt.executeUpdate();

		boolean status = false;
		if (rows > 0) {
			status = true;
		}
		return status;
	}
	
	public ResultSet getBooks() throws SQLException, ClassNotFoundException {
		accessConnection();
		String viewAll = "select * from books";
		PreparedStatement pmt = con.prepareStatement(viewAll);
		ResultSet rs = pmt.executeQuery();
		
		return rs;
	}
}
