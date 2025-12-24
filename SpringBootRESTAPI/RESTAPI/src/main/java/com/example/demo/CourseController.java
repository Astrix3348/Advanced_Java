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
@RequestMapping("/courses")
public class CourseController {

	List<Course> list = new ArrayList<>();

	@PostMapping
	public String addCourse(@RequestBody Course course) {
		list.add(course);
		return "inserted successfully";
	}

	@GetMapping
	public List<Course> viewCourses() {
		return list;
	}

	@GetMapping("/{id}")
	public Course getById(@PathVariable int id) {
		for (Course c : list) {
			if (c.courseId == id) {
				return c;
			}
		}
		return null;
	}

	@PutMapping("/{id}")
	public String updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
		for (Course c : list) {
			if (c.courseId == id) {
				c.setCourseName(updatedCourse.getCourseName());
				c.setDuration(updatedCourse.getDuration());
				break;
			}
		}
		return "updated successfully!";
	}

	@DeleteMapping("/{id}")
	public String delCourse(@PathVariable int id) {
		for (Course c : list) {
			if (c.courseId == id) {
				list.remove(c);
				break;
			}
		}
		return "deleted successfully";
	}

}
