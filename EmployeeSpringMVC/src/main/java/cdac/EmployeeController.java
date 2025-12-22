package cdac;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDAO dao;

	@RequestMapping("/register")
	public String home() {
		return "register";
	}

	@PostMapping("/register")
	public String ToDatabase(@ModelAttribute Employee employee) throws SQLException {
		dao.insertEmployee(employee);

		return "redirect:/view"; // not redirecting to the view.jsp instead making another request so it means
									// our browser will have /view in it hence the request will process further
	}
	@GetMapping("/view")
	public String mainView(Model model) throws SQLException {
		List<Employee> list = dao.getEmployee();
		model.addAttribute("list", list);
		return "view";
	}
}
