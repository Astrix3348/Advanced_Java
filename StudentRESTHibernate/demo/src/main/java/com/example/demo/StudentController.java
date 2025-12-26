package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	public StudentRepo sr;

	public StudentController(StudentRepo sr) {
		this.sr = sr;
	}

	@PostMapping
	public String insert(@RequestBody Student student) {
		sr.save(student);
		return "inserted!!";
	}

	@GetMapping
	public List<Student> viewAll() {
		return sr.findAll();
	}

	@GetMapping("/{prn}")
	public Student getById(@PathVariable int prn) {
		Student exists = sr.findById(prn).orElse(null);
		return exists;
	}

	@PutMapping("/{prn}")
	public String updateById(@PathVariable int prn, @RequestBody Student stu) {
		Student exists = sr.findById(prn).orElse(null);

		exists.setName(stu.getName());
		exists.setPrn(stu.getPrn());

		sr.save(exists);
		return "updated!!";
	}

	@DeleteMapping("/{id}")
	public String delStudents(@PathVariable int id) {
		sr.deleteById(id);
		return "deleted successfully!!";
	}
}
