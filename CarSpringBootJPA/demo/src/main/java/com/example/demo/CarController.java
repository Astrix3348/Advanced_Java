package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

	public CarRepo cr;

	public CarController(CarRepo cr) {
		this.cr = cr;
	}

	@GetMapping("/insert")
	public String insertMapping(Model model) {
		model.addAttribute("car", new Car());
		return "insert";
	}

	@PostMapping("/added")
	public String added(@ModelAttribute Car car, Model model) {
		cr.save(car);
		return "redirect:/view";
	}

	@GetMapping("/view")
	public String viewAll(Model model) {
		model.addAttribute("cars", cr.findAll());
		return "view";
	}

	@GetMapping("/viewId")
	public String mapSearch(Model model) {
		model.addAttribute("car", new Car());
		return "searchById";
	}

	@PostMapping("/viewById")
	public String viewById(@RequestParam int id, Model model) {
		Car car = cr.findById(id).orElse(null);
		model.addAttribute("car", car);
		return "viewSingle";
	}

	@GetMapping("/delete")
	public String delMap(Model model) {
		model.addAttribute("car", new Car());
		return "delete";
	}

	@PostMapping("/delById")
	public String delSuccess(@RequestParam int id) {
		cr.deleteById(id);
		return "success";
	}

	@GetMapping("/update")
	public String mapUpdate(Model model) {
		model.addAttribute("car", new Car());
		return "update";
	}

	@PostMapping("/updated")
	public String updated(@ModelAttribute Car car) {
		Car exists = cr.findById(car.getId()).orElse(null);

		if (exists != null) {
			exists.setBrand(car.getBrand());
			exists.setCost(car.getCost());
			cr.save(exists);
		}
		return "updatedSuccess";
	}
}
