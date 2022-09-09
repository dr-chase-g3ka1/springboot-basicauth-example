package com.chase.example.useraccesspasswords.rest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chase.example.useraccesspasswords.pojos.RegistrationForm;
import com.chase.example.useraccesspasswords.repos.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;

	public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	public String registerForm(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return "registration"; //this one refers to the thymeleaf template in src/main/resources/registration.html
	}

	@PostMapping
	public String processRegistration(@ModelAttribute RegistrationForm form, Model model) {
		model.addAttribute("registrationForm", form);
		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}

}