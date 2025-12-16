package cdac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

	@GetMapping("/register")
	public String mappedRegister() {
		return "register";
	}

	@PostMapping("/register")
	public String registerStudent(@ModelAttribute Student student, Model model)
			throws SQLException, ClassNotFoundException {
		model.addAttribute(student);

		StudentDao sd = new StudentDao();
		boolean stat = sd.addStudent(student);

		if (stat == true) {
			return "success";
		} else {
			return "error";
		}

	}

	@GetMapping("/view")
	public String mappingView() {
		return "view";
	}

	@PostMapping("/view")
	public String viewStudents(@ModelAttribute Student student, Model model)
			throws ClassNotFoundException, SQLException {
		ArrayList<Student> al = new ArrayList<>();
		StudentDao sd = new StudentDao();
		ResultSet rs = sd.viewStudent();

		while (rs.next()) {
			Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			al.add(s);
		}

		model.addAttribute("students", al);

		return "view";
	}
}
