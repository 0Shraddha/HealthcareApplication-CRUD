package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;


import com.luv2code.springboot.thymeleafdemo.entity.Doctor;

public interface DoctorService {

	List<Doctor> findAll();
	
	Doctor findById(int theId);
	
	void save(Doctor theDoctor);
	
	void deleteById(int theId);

	
	
}
