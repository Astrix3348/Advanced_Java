package cdac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	DataSource datasource;

	public void insertEmployee(Employee e) throws SQLException {
		Connection con = null;
		String sql = "insert into employee (e_name, e_income, e_company, e_gender) values (?,?,?,?)";
		con = datasource.getConnection();

		PreparedStatement pmt = con.prepareStatement(sql);
		pmt.setString(1, e.getE_name());
		pmt.setInt(2, e.getE_income());
		pmt.setString(3, e.getE_company());
		pmt.setString(4, e.getE_gender());

		pmt.executeUpdate();
	}

	public List<Employee> getEmployee() throws SQLException {
		Connection con = datasource.getConnection();
		String sql = "select * from employee";
		PreparedStatement pmt = con.prepareStatement(sql);

		List<Employee> list = new ArrayList<>();

		ResultSet rs = pmt.executeQuery();
		

		while (rs.next()) {
			Employee e = new Employee();
			e.setE_name(rs.getString(1));
			e.setE_income(rs.getInt(2));
			e.setE_company(rs.getString(3));
			e.setE_gender(rs.getString(4));
			list.add(e);
		}

		return list;
	}
}
