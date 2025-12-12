package cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection {
	
	Connection con;
	
	public void accessConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc://localhost:3306/practice", "root", "cr7aakash1234");
	}
	
	public boolean ShoppingCart(ShoppingCart s) throws ClassNotFoundException, SQLException {
		accessConnection();
		
		String insertItem = "insert into shopping (s_name, s_password, item, price) values (?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(insertItem);
		
		pmt.setString(1, s.name);
		pmt.setString(2, s.password);
		pmt.setString(3, s.item);
		pmt.setInt(4, s.price);
		
		int rs = pmt.executeUpdate();
		return rs > 0 ? true : false;
	}
	
}