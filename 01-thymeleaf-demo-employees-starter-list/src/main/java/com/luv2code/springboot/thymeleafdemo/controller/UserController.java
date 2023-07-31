package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springboot.thymeleafdemo.entity.User;
import com.luv2code.springboot.thymeleafdemo.service.UserService;


@Controller
public class UserController {

	private UserService userService;
	public UserController(UserService theUserService) {
		super();
		this.userService = theUserService;
	}
	@GetMapping("/showRegistrationForm")
	public String createUserForm(Model model) {
		//create user object to hold user details
		
		User user = new User();
		model.addAttribute("user",user);
		
		return "patients/registration";
	}
	
	@PostMapping("/user")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/showRegistrationForm?success";
	}
	
	
	
//	@PostMapping("/authenticateTheUser")
//	public String authenticateTheUser() {
//	
//		return "redirect:/patients/showAdminIndex";
//	}
	
	
}

	