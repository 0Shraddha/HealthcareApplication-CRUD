package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.DoctorRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorServiceImpl(DoctorRepository theDoctorRepository) {
		doctorRepository = theDoctorRepository;
	}
	
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
}

	@Override
	public Doctor findById(int theId) {
		Optional<Doctor> result = doctorRepository.findById(theId);
		
		Doctor theDoctor = null;
		
		if (result.isPresent()) {
			theDoctor = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find doctor id - " + theId);
		}
		
		return theDoctor;
	}
	
	@Override
	public void save(Doctor theDoctor) {
		doctorRepository.save(theDoctor);
	}

	@Override
	public void deleteById(int theId) {
		doctorRepository.deleteById(theId);
	}

}






