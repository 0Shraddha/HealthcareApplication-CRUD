package com.luv2code.springboot.thymeleafdemo.dao;
import java.util.Optional;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Blogs;


public interface BlogsRepository extends JpaRepository<Blogs, Integer> {

	Optional<Blogs> findById(Long id);


	// that's it ... no need to write any code LOL!
	
	
	//add a method to sort by name
//	public List<Patient> findAllByOrderByFirstNameAsc();
	
}
