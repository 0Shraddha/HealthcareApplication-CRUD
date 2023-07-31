package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.AmbulanceRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Ambulance;



@Service
public class AmbulanceServiceImpl implements AmbulanceService {
	

	private AmbulanceRepository ambulanceRepository;
	
	
	public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository) {
		super();
		this.ambulanceRepository = ambulanceRepository;
	}
	
	@Override
	public List<Ambulance> getAllAmbulance() {
		return ambulanceRepository.findAll();
}

	@Override
	public Ambulance saveAmbulance(Ambulance ambulance) {
		return ambulanceRepository.save(ambulance);
	}
	
	@Override
	public Ambulance getAmbulanceById(int id) {
		return ambulanceRepository.findById(id).get();
	}
//	@Override
//	public Ambulance updateAmbulance(Ambulance ambulance) {
//		return ambulanceRepository.save(ambulance);
//	}
	@Override
	public void deleteAmbulanceById(int id) {
		ambulanceRepository.deleteById(id);
	}
	
	@Override
	public Ambulance findById(int theId) {
		Optional<Ambulance> result = ambulanceRepository.findById(theId);
		
		Ambulance theAmbulance = null;
		
		if (result.isPresent()) {
			theAmbulance = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Ambulance id - " + theId);
		}
		
		return theAmbulance;
	}
	
}




