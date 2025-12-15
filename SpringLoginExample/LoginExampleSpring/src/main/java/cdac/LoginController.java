package cdac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String mappingLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("name") String u_name, @RequestParam("pass") String u_pass, Model model) {

		if (u_name.equals("aakash") && u_pass.equals("1234")) {
			model.addAttribute("myname", u_name);
			return "welcome";
		} else {
			model.addAttribute("error", "invalid user or pass");
			return "error";
		}

	}
}
