package com.luv2code.springboot.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Blood;
import com.luv2code.springboot.thymeleafdemo.service.BloodService;

@Controller
//@RequestMapping("/blood")
public class BloodController {

private BloodService bloodService;

public BloodController(BloodService theBloodService) {
	super();
	this.bloodService = theBloodService;
}
//add mapping for "/list"
@GetMapping("/showBloodForAdmin")
public String listBlood(Model model) {
		//get patient from db
	model.addAttribute("blood",bloodService.getAllBlood());

		return "patients/admin-blood";
	}
@GetMapping("/showBloodForUser")
public String listBlood1(Model model) {
	model.addAttribute("blood",bloodService.getAllBlood());

	
		return "patients/admin-blood";
	}
@GetMapping("/showBloodForm")
public String createBloodForm(Model model) {
	//create blood object to hold blood details
	
	Blood blood = new Blood();
	model.addAttribute("blood",blood);
	
	return "patients/AddBloodForm";
}

@PostMapping("/blood")
public String saveBlood(@ModelAttribute("blood") Blood blood) {
	bloodService.saveBlood(blood);
	return "redirect:/showBloodForAdmin";
}

//@GetMapping("/showBloodFormForUpdate/{id}")
//public String updateBloodForm(@PathVariable int id,
//		@ModelAttribute("blood") Blood blood,
//		Model model) {
//	
//	//get blood from db by id
//	Blood existingBlood = bloodService.getBloodById(id);
//	existingBlood.setId(id);
//	existingBlood.setHospital(blood.getHospital());
//	existingBlood.setContact(blood.getContact());
//	existingBlood.setBloodgroup(blood.getBloodgroup());
//	
//	//save updated blood details
//	bloodService.updateBlood(existingBlood);
//	return "patients/AddBloodForm";
//}
@GetMapping("/showBloodFormForUpdate")
public String showFormForUpdate(@RequestParam("bloodId")int theId, Model theModel) {
	//get the doctor from the service
	Blood theBlood = bloodService.findById(theId);
	//set the doctor in the model to pre populate the form
	theModel.addAttribute("blood",theBlood);
	//send over to our form
	return "patients/AddBloodForm";
}

//@GetMapping("/deleteBlood/{id}")
//public String deleteBlood(@PathVariable int id) {
//	//delete the patient
//	bloodService.deleteBloodById(id);
//	
//	//redirect to the /patient/list
//	return "redirect:/showBloodForAdmin";
//}
@GetMapping("/deleteBlood")
public String delete(@RequestParam("bloodId")int theId) {
	//delete the Doctor
	bloodService.deleteBloodById(theId);
	
	//redirect to the /patient/list
	return "redirect:/showBloodForAdmin";
}


//@PostMapping("/saveBlood")
//public String saveBlood(@ModelAttribute("blood") Blood blood) {
//	
//	//save the patient
//	bloodService.saveBlood(blood);
//	
//	//use a redirect to prevent duplicate submissions
//	return "redirect:/patients/admin-blood?success";
//}

}
