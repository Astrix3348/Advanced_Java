package cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cdac.Project;
import cdac.ProjectDAO;

@Controller
public class ProjectController {

	@Autowired
	ProjectDAO dao;

	@RequestMapping("/register")
	public String home() {
		return "register";
	}

	@PostMapping("/addProject")
	public String adding(@ModelAttribute Project p) {

		dao.insertProject(p);
		return "redirect:/view"; // making another request using redirect
	}
	
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}

	@GetMapping("/searchResult")
	public String searching(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("list", dao.searchProject(keyword));
		return "view";
	}

	@GetMapping("/view")
	public String viewing(Model model) {
		model.addAttribute("list", dao.getProject());
		return "view";
	}

}
