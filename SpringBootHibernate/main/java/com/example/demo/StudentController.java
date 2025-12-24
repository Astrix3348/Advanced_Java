package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	public StudentRepository sr;

	public StudentController(StudentRepository sr) {
		this.sr = sr;
	}

	@GetMapping("/register")
	public String mappingReg(Model model) {
		model.addAttribute("students", new Student());
		return "register";
	}

	@PostMapping("/registerStudent")
	public String afterReg(@ModelAttribute Student student) {
		sr.save(student);
		return "success";
	}

	@GetMapping("/view")
	public String viewing(Model model) {
		model.addAttribute("list", sr.findAll());
		return "view";
	}

	@GetMapping("/delete")
	public String delStudents(Model model) {
		model.addAttribute("students", new Student());
		return "delete";
	}

	@PostMapping("/deleteStudent")
	public String deletingStudents(@ModelAttribute Student student) {
		sr.deleteById(student.s_id);
		return "delSuccess";
	}

	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable int id, Model model) {

		Student student = sr.findById(id).get(); // we are fetching this from the database
		model.addAttribute("students", student);

		return "update";
	}

	@PostMapping("/updateStudent")
	public String updatedStudent(@ModelAttribute Student student) {
		sr.save(student); // update because id exists
		return "successUpdate";
	}
}
