package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.entity.Doctor;
import com.luv2code.springboot.thymeleafdemo.service.DoctorService;
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
public class DoctorController {

private DoctorService doctorService;

public DoctorController(DoctorService theDoctorService) {
	doctorService = theDoctorService;
}

//add mapping for "/list"
@GetMapping("/listDoctors")
public String listDoctor(Model theModel) {
		//get patient from db
		List<Doctor> theDoctor = doctorService.findAll();
		
		// add to the spring model that can be used in thymeleaf template
		theModel.addAttribute("doctor", theDoctor);

		return "patients/list-doctors";
	}
@GetMapping("/listDoctorsInForm")
public String listDoctorInForm(Model theModel) {
		//get patient from db
		List<Doctor> theDoctor = doctorService.findAll();
		
		// add to the spring model that can be used in thymeleaf template
		theModel.addAttribute("doctor", theDoctor);

		return "patients/AddPatientForm";
	}
//@GetMapping("/showFormForAdd")
//public String showFormForAdd1(Model theModel) {
//	//create model attribute to bind form data
//	Doctor theDoctor = new Doctor();
//	theModel.addAttribute("doctor", theDoctor);
//	
//	
//	return "patients/addPatientForm";
//}
@GetMapping("/showAdminIndex")
public String listDoctorInIndex(Model theModel) {
		//get patient from db
		List<Doctor> theDoctor = doctorService.findAll();
		
		// add to the spring model that can be used in thymeleaf template
		theModel.addAttribute("doctor", theDoctor);

		return "patients/Admin-index";
	}

@GetMapping("/showDoctorForUser")
public String showDoctorForUser(Model theModel) {
	//get doctor from db
			List<Doctor> theDoctor = doctorService.findAll();
			
			// add to the spring model that can be used in thymeleaf template
			theModel.addAttribute("doctor", theDoctor);

			return "patients/listDoctors";
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

@GetMapping("/showFormForAddForDoctor")
public String showFormForAdd(Model theModel) {
	//create model attribute to bind form data
	Doctor theDoctor = new Doctor();
	theModel.addAttribute("doctor", theDoctor);
	
	return "patients/AddDoctorForm";
}

//
//@GetMapping("/showDoctor")
//public String showDoctor(Model theModel) {
//	//create model attribute to bind form data
//	Patient thePatient = new Patient();
//	theModel.addAttribute("patient", thePatient);
//	
//	return "patients/doctor";
//}




@GetMapping("/showFormForUpdateDoctor")
public String showFormForUpdate(@RequestParam("doctorId")int theId, Model theModel) {
	//get the doctor from the service
	Doctor theDoctor = doctorService.findById(theId);
	//set the doctor in the model to pre populate the form
	theModel.addAttribute("doctor",theDoctor);
	//send over to our form
	return "patients/AddDoctorForm";
}

@PostMapping("/saveDoctor")
public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor) {
	
	//save the Doctor
	doctorService.save(theDoctor);
	
	//use a redirect to prevent duplicate submissions
	return "redirect:/patients/listDoctors?success";
}

	
@GetMapping("/deleteDoctor")
public String delete(@RequestParam("doctorId")int theId) {
	//delete the Doctor
	doctorService.deleteById(theId);
	
	//redirect to the /patient/list
	return "redirect:/patients/listDcotors";
}

}









