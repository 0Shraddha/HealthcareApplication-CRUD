package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.BlogsRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Blogs;



@Service
public class BlogsServiceImpl implements BlogsService {
	

	private BlogsRepository blogsRepository;
	
	
	public BlogsServiceImpl(BlogsRepository blogsRepository) {
		super();
		this.blogsRepository = blogsRepository;
	}
	
	@Override
	public List<Blogs> getAllBlog() {
		return blogsRepository.findAll();
}

	@Override
	public Blogs saveBlogs(Blogs blogs) {
		return blogsRepository.save(blogs);
	}
	
	@Override
	public Blogs getBlogsById(int id) {
		return blogsRepository.findById(id).get();
	}
//	@Override
//	public Ambulance updateAmbulance(Ambulance ambulance) {
//		return ambulanceRepository.save(ambulance);
//	}
	@Override
	public void deleteBlogsById(int id) {
		blogsRepository.deleteById(id);
	}
	
	@Override
	public Blogs findById(int theId) {
		Optional<Blogs> result = blogsRepository.findById(theId);
		
		Blogs theBlogs = null;
		
		if (result.isPresent()) {
			theBlogs = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find blogs id - " + theId);
		}
		
		return theBlogs;
	}
	
}




