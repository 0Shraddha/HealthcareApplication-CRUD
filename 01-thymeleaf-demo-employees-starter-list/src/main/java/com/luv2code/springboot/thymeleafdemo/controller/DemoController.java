 package com.luv2code.springboot.thymeleafdemo.controller;
 
 import org.springframework.stereotype.Controller;
 
 import org.springframework.web.bind.annotation.GetMapping;

 @Controller
 public class DemoController {
 
 	 // create a mapping for "/hello"
	 
	 @GetMapping("/showWebsite")
	 public String showWebsite() {
	
	 	return "patients/Website";
	 }
	 
	
	
	 
 	@GetMapping("/showAdminIndex")
 	public String showAdminIndex() {
 		
 		return "patients/Admin-index";
 	}
 	 }
 
 
 
 
 
 
 
 
