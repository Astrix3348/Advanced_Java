package com.example.demo;

import java.util.ArrayList;
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
@RequestMapping("/students")
public class StudentController {
	List<Student> students = new ArrayList<>();

	@PostMapping
	public String insertStudents(@RequestBody Student student) {
		students.add(student);
		return "success!!";
	}

	@GetMapping
	public List<Student> showStudents() {
		return students;
	}

	@PutMapping("/{id}")
	public String updateStudents(@PathVariable int id, @RequestBody Student student) {
		for (Student s : students) {
			if (s.getId() == id) {
				s.setName(student.name);
				s.setCourse(student.course);
				s.setMarks(student.marks);
				break;
			}
		}
		return "update!!";
	}

	@DeleteMapping("/{id}")
	public String delStudents(@PathVariable int id) {
		for (Student s : students) {
			if (s.getId() == id) {
				students.remove(s);
			}
		}
		return "deleted!!";
	}
}
