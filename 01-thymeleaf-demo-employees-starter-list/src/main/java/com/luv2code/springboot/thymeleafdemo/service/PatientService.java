package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;


import com.luv2code.springboot.thymeleafdemo.entity.Patient;

public interface PatientService {

	List<Patient> findAll();
	
	Patient findById(int theId);
	
	void save(Patient theEmployee);
	
	void deleteById(int theId);

	
	
}
