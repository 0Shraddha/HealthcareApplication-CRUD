package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.PatientRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository employeeRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Patient> findAll() {
		return employeeRepository.findAll();
}

	@Override
	public Patient findById(int theId) {
		Optional<Patient> result = employeeRepository.findById(theId);
		
		Patient theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find patient id - " + theId);
		}
		
		return theEmployee;
	}
	
	@Override
	public void save(Patient theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}






