package bucket.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

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
}

record UserDTO(String fullName, MultipartFile file) {}