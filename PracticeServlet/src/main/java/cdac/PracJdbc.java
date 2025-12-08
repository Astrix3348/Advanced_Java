package cdac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PracJdbc {
	Connection con;
	
	public void accessConnnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "cr7aakash1234");
	}
	
	public boolean employees(Employee e) throws ClassNotFoundException, SQLException {
		accessConnnection();
		
		String insertEmployee = "insert into newEmp(id, e_name, e_sal) values(?,?,?)";
		PreparedStatement pmt = con.prepareStatement(insertEmployee);
		
		
		pmt.setInt(1, e.id);
		pmt.setString(2, e.e_name);
		pmt.setInt(3, e.e_sal);
		
		int row = pmt.executeUpdate();
		boolean stat = false;
		if(row > 0) {
			stat = true;
		}
		return stat;
			
	}
	
	public ResultSet getEmployee() throws ClassNotFoundException, SQLException {
		accessConnnection();
		String viewEmp = "select * from newEmp";
		PreparedStatement pmt = con.prepareStatement(viewEmp);
		ResultSet rs = pmt.executeQuery();
		
		return rs;
	}
}
