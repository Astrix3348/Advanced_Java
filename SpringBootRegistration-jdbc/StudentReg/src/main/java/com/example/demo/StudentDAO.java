package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	public DataSource dataSource;

	public StudentDAO(DataSource dataSource) { //this is a dependency injection
		//we always have to make a constructor in order to tell spring explicitly to inject the dependencies
		this.dataSource = dataSource;
	}

	public void insertStudent(Student s) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "insert into students (s_name, s_prn) values (?, ?)";
		PreparedStatement pmt = con.prepareStatement(sql);
		pmt.setString(1, s.getS_name());
		pmt.setInt(2, s.getS_prn());

		pmt.executeUpdate();
	}

	public List<Student> showStudents() throws SQLException {
		List<Student> list = new ArrayList<>();

		String sql = "select * from students";

		Connection con = dataSource.getConnection();

		PreparedStatement pmt = con.prepareStatement(sql);

		ResultSet rs = pmt.executeQuery();

		while (rs.next()) {
			Student s = new Student();
			s.setS_name(rs.getString(1));
			s.setS_prn(rs.getInt(2));

			list.add(s);

		}

		return list;

	}
}
