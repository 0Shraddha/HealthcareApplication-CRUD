package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Blood;

public interface BloodService {

	List<Blood> getAllBlood();

	Blood saveBlood(Blood blood);
	
	Blood getBloodById(int id);
	
	//Blood updateBlood(Blood blood);

	void deleteBloodById(int id);

	Blood findById(int theId);

	
	
}
