package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Ambulance;

public interface AmbulanceService {

	List<Ambulance> getAllAmbulance();

	Ambulance saveAmbulance(Ambulance ambulance);
	
	Ambulance getAmbulanceById(int id);
	
	//Ambulance updateAmbulance(Ambulance ambulance);

	void deleteAmbulanceById(int id);

	Ambulance findById(int theId);

	
	
	
}
