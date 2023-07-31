package com.luv2code.springboot.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Blogs;
import com.luv2code.springboot.thymeleafdemo.service.BlogsService;


@Controller
//@RequestMapping("/ambulance")
public class BlogsController {

private BlogsService blogsService;

public BlogsController(BlogsService theBlogsService) {
	super();
	this.blogsService = theBlogsService;
}
//add mapping for "/list"
@GetMapping("/showBlogsForAdmin")
public String listBlog(Model model) {
		//get blog from db
	model.addAttribute("blogs",blogsService.getAllBlog());

		return "patients/blog";
	}
//@GetMapping("/showAmbulanceForUser")
//public String listAmbulance1(Model model) {
//	model.addAttribute("ambulance",ambulanceService.getAllAmbulance());
//
//	
//		return "patients/admin-ambulance";
//	}
@GetMapping("/showBlogForm")
public String createBlogsForm(Model model) {
	//create Ambulance object to hold Ambulance details
	
	Blogs blogs = new Blogs();
	model.addAttribute("blogs",blogs);
	
	return "patients/addBlog";
}

@PostMapping("/blogs")
public String saveBlogs(@ModelAttribute("blogs") Blogs blogs) {
	blogsService.saveBlogs(blogs);
	return "redirect:/showBlogsForAdmin";
}

//@GetMapping("/showAmbulanceFormForUpdate/{id}")
//public String updateAmbulanceForm(@PathVariable int id,
//		@ModelAttribute("ambulance") Ambulance ambulance,
//		Model model) {
//	
//	//get blood from db by id
//	Ambulance existingAmbulance = ambulanceService.getAmbulanceById(id);
//	existingAmbulance.setId(id);
//	existingAmbulance.setHospital(ambulance.getHospital());
//	existingAmbulance.setContact(ambulance.getContact());
//	existingAmbulance.setLocation(ambulance.getLocation());
//	
//	//save updated Ambulance details
//	ambulanceService.updateAmbulance(existingAmbulance);
//	return "patients/AddAmbulanceForm";
//}
@GetMapping("/showBlogsFormForUpdate")
public String showFormForUpdate(@RequestParam("blogsId")int theId, Model theModel) {
	//get the doctor from the service
	Blogs theBlogs = blogsService.findById(theId);
	//set the doctor in the model to pre populate the form
	theModel.addAttribute("blogs",theBlogs);
	//send over to our form
	return "patients/addBlog";
}

//@GetMapping("/deleteAmbulance/{id}")
//public String deleteAmbulance(@PathVariable int id) {
//	//delete the Ambulance
//	ambulanceService.deleteAmbulanceById(id);
//	
//	//redirect to the /patient/list
//	return "redirect:/showAmbulanceForAdmin";
//}
@GetMapping("/deleteBlogs")
public String delete(@RequestParam("blogsId")int theId) {
	//delete the Doctor
	blogsService.deleteBlogsById(theId);
	
	//redirect to the /patient/list
	return "redirect:/showBlogsForAdmin";
}

}
