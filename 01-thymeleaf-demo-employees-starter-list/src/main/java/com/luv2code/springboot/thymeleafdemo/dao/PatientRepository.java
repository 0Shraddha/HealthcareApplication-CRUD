package com.luv2code.springboot.thymeleafdemo.dao;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	// that's it ... no need to write any code LOL!
	
	
	//add a method to sort by name
//	public List<Patient> findAllByOrderByFirstNameAsc();
	
}
