package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.entity.Patient;
import com.luv2code.springboot.thymeleafdemo.service.PatientService;
//import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

private PatientService patientService;

public PatientController(PatientService thePatientService) {
	patientService = thePatientService;
}

//add mapping for "/list"
@GetMapping("/list")
public String listEmployees(Model theModel) {
		//get patient from db
		List<Patient> thePatients = patientService.findAll();
		
		// add to the spring model that can be used in thymeleaf template
		theModel.addAttribute("patients", thePatients);

		return "patients/list-patients";
	}
	
//@GetMapping("/showLoginPage")
//public String login(@RequestParam("username") String username,
//                    @RequestParam("password") String password,
//                    Model model) {
//    // Check if the username and password match with the registered users
//    boolean isValidUser = checkCredentials(username, password);
//
//    if (isValidUser) {
//        // Successful login
//        return "redirect:/";
//    } else {
//        // Invalid login credentials
//        model.addAttribute("invalid", true);
//        return "form-login";
//    }
//}
//
//private boolean checkCredentials(String username, String password) {
//	// TODO Auto-generated method stub
//	return false;
//}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	
	return "patients/AddPatientForm";
}

@GetMapping("/showFormForAddUser")
public String showFormForAddUser(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/addPatientFormUser?success";
}

//@GetMapping("/showFormBloodForAdmin")
//public String showFormBloodForAdmin(Model theModel) {
////	//create model attribute to bind form data
//	Patient thePatient = new Patient();
//	theModel.addAttribute("blood", thePatient);	
//	return "patients/form-blood";
//}
//@GetMapping("/showBloodForAdmin")
//public String showBloodForAdmin(Model theModel) {
//	
//	//get blood from db
//			List<Patient> thePatient = patientService.findAll();
//			
//			// add to the spring model that can be used in thymeleaf template
//			theModel.addAttribute("blood", thePatient);
//
//			return "patients/admin-blood";
//}
@GetMapping("/showAmbulanceForAdmin")
public String showAmbulanceForAdmin(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/admin-ambulance";
}
//@GetMapping("/showBlog")
//public String showBlog(Model theModel) {
//	//create model attribute to bind form data
//	Patient thePatient = new Patient();
//	theModel.addAttribute("patient", thePatient);
//	
//	return "patients/blog";
//}

@GetMapping("/showRestrictAccess")
public String showRestrictAccess(Model theModel) {
	//create model attribute to bind form data
	Patient thePatient = new Patient();
	theModel.addAttribute("patient", thePatient);
	
	return "patients/RestrictAccess";
}
	

@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("patientId")int theId, Model theModel) {
	//get the patient from the service
	Patient thePatient = patientService.findById(theId);
	//set the patient in the model to pre populate the form
	theModel.addAttribute("patient",thePatient);
	//send over to our form
	return "patients/AddPatientForm";
}

@PostMapping("/save")
public String savePatient(@ModelAttribute("patient") Patient thePatient) {
	
	//save the patient
	patientService.save(thePatient);
	
	//use a redirect to prevent duplicate submissions
	return "redirect:/patients/list?success";
}
//@PostMapping("/saveBlood")
//public String saveBlood(@ModelAttribute("blood") Blood thePatient) {
//	
//	//save the blood
//	BloodService.saveBlood(thePatient);
//	
//	//use a redirect to prevent duplicate submissions
//	return "redirect:/patients/showBloodForAdmin";
//}
@PostMapping("/newForm")
public String savePatientUser(@ModelAttribute("patient") Patient thePatient) {
	
	//save the patient
	patientService.save(thePatient);
	
	//use a redirect to prevent duplicate submissions
	return "redirect:/patients/list?success";
}

@GetMapping("/delete")
public String delete(@RequestParam("patientId")int theId) {
	//delete the patient
	patientService.deleteById(theId);
	
	//redirect to the /patient/list
	return "redirect:/patients/list";
}

}









