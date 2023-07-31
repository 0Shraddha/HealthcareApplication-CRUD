package com.luv2code.springboot.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Ambulance;
import com.luv2code.springboot.thymeleafdemo.service.AmbulanceService;


@Controller
//@RequestMapping("/ambulance")
public class AmbulanceController {

private AmbulanceService ambulanceService;

public AmbulanceController(AmbulanceService theAmbulanceService) {
	super();
	this.ambulanceService = theAmbulanceService;
}
//add mapping for "/list"
@GetMapping("/showAmbulanceForAdmin")
public String listAmbulance(Model model) {
		//get patient from db
	model.addAttribute("ambulance",ambulanceService.getAllAmbulance());

		return "patients/admin-ambulance";
	}
@GetMapping("/showAmbulanceForUser")
public String listAmbulance1(Model model) {
	model.addAttribute("ambulance",ambulanceService.getAllAmbulance());

	
		return "patients/admin-ambulance";
	}
@GetMapping("/showAmbulanceForm")
public String createAmbulanceForm(Model model) {
	//create Ambulance object to hold Ambulance details
	
	Ambulance ambulance = new Ambulance();
	model.addAttribute("ambulance",ambulance);
	
	return "patients/AddAmbulanceForm";
}

@PostMapping("/ambulance")
public String saveAmbulance(@ModelAttribute("ambulance") Ambulance ambulance) {
	ambulanceService.saveAmbulance(ambulance);
	return "redirect:/showAmbulanceForAdmin";
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
@GetMapping("/showAmbulanceFormForUpdate")
public String showFormForUpdate(@RequestParam("ambulanceId")int theId, Model theModel) {
	//get the doctor from the service
	Ambulance theAmbulance = ambulanceService.findById(theId);
	//set the doctor in the model to pre populate the form
	theModel.addAttribute("ambulance",theAmbulance);
	//send over to our form
	return "patients/AddAmbulanceForm";
}

//@GetMapping("/deleteAmbulance/{id}")
//public String deleteAmbulance(@PathVariable int id) {
//	//delete the Ambulance
//	ambulanceService.deleteAmbulanceById(id);
//	
//	//redirect to the /patient/list
//	return "redirect:/showAmbulanceForAdmin";
//}
@GetMapping("/deleteAmbulance")
public String delete(@RequestParam("ambulanceId")int theId) {
	//delete the Doctor
	ambulanceService.deleteAmbulanceById(theId);
	
	//redirect to the /patient/list
	return "redirect:/showAmbulanceForAdmin";
}

}
