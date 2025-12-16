package springMVC;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	
	
	@Autowired
	StudentDAO dao;
	
	@GetMapping("/register")
	public String showForm() {
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registration(@ModelAttribute Student student, Model model) throws SQLException {
		dao.registerStudent(student);
		return "redirect:/view"; // redirect is used when to not go to a jsp/html page instead tell the browser to make another request 
	}
	
	@GetMapping("/view")
	public String viewingStu(Model model) throws SQLException {
		ArrayList<Student> al = dao.viewAllStudents();
		model.addAttribute("students", al);
		return "view";
 	}
}















