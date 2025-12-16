package springMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAO {

	@Autowired
	DataSource dataSource;

	// register the student
	public void registerStudent(Student student) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;

		con = dataSource.getConnection();

		String addStu = "insert into student (s_id, s_name, s_email, s_course) values (?,?,?,?)";
		ps = con.prepareStatement(addStu);

		ps.setInt(1, student.getS_id());
		ps.setString(2, student.getS_name());
		ps.setString(3, student.getS_email());
		ps.setString(4, student.getS_course());

		ps.executeUpdate();
	}

	public ArrayList<Student> viewAllStudents() throws SQLException {
		ArrayList<Student> al = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = dataSource.getConnection();

		String viewStu = "select * from student";

		ps = con.prepareStatement(viewStu);
		rs = ps.executeQuery();

		while (rs.next()) {
			Student s = new Student();
			s.setS_id(rs.getInt(1));
			s.setS_name(rs.getString(2));
			s.setS_email(rs.getString(3));
			s.setS_course(rs.getString(4));
			
			al.add(s);

		}

		return al;
	}
}
