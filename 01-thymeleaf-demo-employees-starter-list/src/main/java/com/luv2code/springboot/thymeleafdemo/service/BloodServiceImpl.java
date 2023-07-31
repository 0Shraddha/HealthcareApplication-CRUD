package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.BloodRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Blood;


@Service
public class BloodServiceImpl implements BloodService {
	

	private BloodRepository bloodRepository;
	
	
	public BloodServiceImpl(BloodRepository bloodRepository) {
		super();
		this.bloodRepository = bloodRepository;
	}
	
	@Override
	public List<Blood> getAllBlood() {
		return bloodRepository.findAll();
}

	@Override
	public Blood saveBlood(Blood blood) {
		return bloodRepository.save(blood);
	}
	
	@Override
	public Blood getBloodById(int id) {
		return bloodRepository.findById(id).get();
	}
//	@Override
//	public Blood updateBlood(Blood blood) {
//		return bloodRepository.save(blood);
//	}
	@Override
	public void deleteBloodById(int id) {
		 bloodRepository.deleteById(id);
	}

	@Override
	public Blood findById(int theId) {
		Optional<Blood> result = bloodRepository.findById(theId);
		
		Blood theBlood = null;
		
		if (result.isPresent()) {
			theBlood = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find blood id - " + theId);
		}
		
		return theBlood;
	}
	
	
}




