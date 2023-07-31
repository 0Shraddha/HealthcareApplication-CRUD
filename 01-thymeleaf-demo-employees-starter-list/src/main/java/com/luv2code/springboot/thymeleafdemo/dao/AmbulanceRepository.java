package com.luv2code.springboot.thymeleafdemo.dao;
import java.util.Optional;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Ambulance;


public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {

	Optional<Ambulance> findById(Long id);


	// that's it ... no need to write any code LOL!
	
	
	//add a method to sort by name
//	public List<Patient> findAllByOrderByFirstNameAsc();
	
}
