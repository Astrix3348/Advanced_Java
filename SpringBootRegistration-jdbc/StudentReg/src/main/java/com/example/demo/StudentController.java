package com.example.demo;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	StudentDAO dao;
	
	public StudentController(StudentDAO dao) {
		this.dao = dao;
	}
	
	
	@GetMapping("/register")
	public String home(Model model) {
		model.addAttribute("student", new Student()); //the controller sends the register.html an empty student object 
		return "register";
	}
	
	@PostMapping("/register")
	public String registration(@ModelAttribute Student student) throws SQLException {
		dao.insertStudent(student);
		return "success";
	}
	
	@GetMapping("/view")
	public String showStudent(@ModelAttribute Student student, Model model) throws SQLException {
		model.addAttribute("list", dao.showStudents());
		return "view";
	}
	
}
