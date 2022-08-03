package bucket.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bucket.demo.dtos.UserDTO;
import bucket.demo.entities.User;
import bucket.demo.services.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	private UserService service;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("users", service.findAll());
		return "list";
	}
	
	@GetMapping("/add")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/add")
	public String save(UserDTO user) {
		service.save(user);
		return "redirect:/";
	}
}
