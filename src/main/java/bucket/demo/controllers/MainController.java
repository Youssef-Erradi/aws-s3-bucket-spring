package bucket.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bucket.demo.entities.User;
import bucket.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	private UserRepository repository;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("users", repository.findAll());
		return "list";
	}
	
	@GetMapping("/add")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
}
