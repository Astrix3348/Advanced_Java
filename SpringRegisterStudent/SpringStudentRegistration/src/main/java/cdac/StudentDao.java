package cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	Connection con;
	
	public void accessConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "cr7aakash1234");
		
	}
	
	public boolean addStudent(Student s) throws SQLException, ClassNotFoundException {
		accessConnection();
		String insertStu = "insert into student (s_id, s_name, s_email, s_course) values (?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(insertStu);
		
		pmt.setInt(1, s.getS_id());
		pmt.setString(2, s.getS_name());
		pmt.setString(3, s.getS_email());
		pmt.setString(4, s.getS_course());
		
		
		int row = pmt.executeUpdate();
		
		return row > 0 ? true : false;
	}
	
	public ResultSet viewStudent() throws ClassNotFoundException, SQLException {
		accessConnection();
		String viewStu = "select * from student";
		PreparedStatement pmt = con.prepareStatement(viewStu);
		
		
		ResultSet rs = pmt.executeQuery();
		
		return rs;
	}
}
