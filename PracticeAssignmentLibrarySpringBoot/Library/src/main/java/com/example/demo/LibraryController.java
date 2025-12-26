package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LibraryController {
	public LibraryRepository lr;

	public LibraryController(LibraryRepository lr) { // dependency injection
		this.lr = lr;
	}

	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/add")
	public String addBooks(Model model) {
		model.addAttribute("library", new Libraries());
		return "addBook";
	}

	@GetMapping("/view")
	public String viewAll(Model model) {
		model.addAttribute("books", lr.findAll());
		return "viewBook";

	}
	
	@PostMapping("/searchById")
	public String viewById(@RequestParam int id, Model model) {
		
		Libraries book = lr.findById(id).orElse(null);
		
		model.addAttribute("books", book);
		return "searchById";
	}

	@PostMapping("/view")
	public String viewBooks(@ModelAttribute Libraries library, Model model) {
		lr.save(library);
		return "redirect:/view";
	}

	@GetMapping("/search")
	public String searchMapping(Model model) {
		model.addAttribute("books", new Libraries());
		return "search";
	}

}
