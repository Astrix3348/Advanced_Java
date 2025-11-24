package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableStatementEx {

	public static Connection con;

	public void accessConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner(System.in);
		CallableStatementEx cs = new CallableStatementEx();
		cs.accessConnection();

		System.out.println("connected to database.");
		CallableStatement cls = con.prepareCall("{ call getAnnualSal (?, ?, ?)}");

		System.out.println("enter the emp_id");
		int emp_id = s.nextInt();
		cls.setInt(1, emp_id);

		cls.registerOutParameter(2, Types.VARCHAR);
		cls.registerOutParameter(3, Types.INTEGER);

		cls.executeQuery();

		String emp_Name = cls.getString(2);
		int AnnualSalary = cls.getInt(3);

		if (emp_Name != null) {
			System.out.println(emp_Name + " has: " + AnnualSalary + " annual package");
		} else {
			System.out.println("employee number: " + emp_id + " does not exists.");
		}
	}
}
