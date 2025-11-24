package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//steps for connecting database to java.
/*
 * load the drivers
 * get connection
 * create query 
 * create statement
 * execute query
 * iterate result set
 * close connection
*/
public class PreparedStatementEx {
	static Scanner s = new Scanner(System.in);
	public Connection con;

	public void display(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.println("-----------------");
			System.out.print(rs.getInt("emp_id"));
			System.out.print(" | ");
			System.out.print(rs.getString("emp_name"));
			System.out.print(" | ");
			System.out.println(rs.getString("emp_sal"));
		}
		System.out.println("-----------------");
	}

	public void accessConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "cr7aakash1234");
	}

	public void getAll() throws SQLException {
		String selectAll = "select * from emp";
		PreparedStatement selectingAll = con.prepareStatement(selectAll);
		ResultSet rs = selectingAll.executeQuery();

		display(rs);
	}

	public void getById() throws SQLException {
		String selectById = "select * from emp where emp_id = ?";
		PreparedStatement selectingById = con.prepareStatement(selectById);
		System.out.print("Enter the id for which you want the details: ");
		int id = s.nextInt();
		selectingById.setInt(1, id);
		ResultSet rs = selectingById.executeQuery();

		display(rs);
	}

	public void insertEmp() throws SQLException {
		String insert = "insert into emp (emp_name, emp_sal) values (?,?)";
		PreparedStatement inserting = con.prepareStatement(insert);
		System.out.println("Enter the Name of the employee to insert: ");
		String empName = s.next();
		System.out.print("Enter the salary of employee: ");
		int salary = s.nextInt();
		inserting.setString(1, empName);
		inserting.setInt(2, salary);

		inserting.executeUpdate();

		System.out.println("Data inserted successfully!");
	}

	public void updateEmp() throws SQLException {
		String updateById = "update emp set emp_name = ?, emp_sal = ? where emp_id = ?";
		PreparedStatement updating = con.prepareStatement(updateById);
		System.out.print("Enter the Employee Id whose values to update: ");
		int id = s.nextInt();

		System.out.print("Enter the new Name for employee: ");
		String name = s.next();

		System.out.print("Enter the updated salary for employee: ");
		int newSal = s.nextInt();

		updating.setString(1, name);
		updating.setInt(2, newSal);
		updating.setInt(3, id);

		updating.executeUpdate();

		System.out.println("Data updated successfully!");
	}

	public void deleteEmp() throws SQLException {
		String deleteById = "delete from emp where emp_id = ?";
		PreparedStatement deleting = con.prepareStatement(deleteById);
		System.out.print("Enter the id of employee you want to delete: ");
		int id = s.nextInt();

		deleting.setInt(1, id);
		deleting.executeUpdate();
		System.out.println("Deleted successfully!");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PreparedStatementEx px = new PreparedStatementEx();
		px.accessConnection();

		int choice;

		do {
			System.out.println("\n==== Employee Management ====");
			System.out.println("1. View All Employees");
			System.out.println("2. View Specific Employees");
			System.out.println("3. Insert Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit.");

			System.out.print("Enter Choice: ");
			choice = s.nextInt();

			switch (choice) {
			case 1:
				px.getAll();
				break;
			case 2:
				px.getById();
				break;
			case 3:
				px.insertEmp();
				break;
			case 4:
				px.updateEmp();
				break;
			case 5:
				px.deleteEmp();
				break;
			default:
				System.out.println("Invalid input!!");
				break;
			}
		} while (choice != 6);
	}
}
