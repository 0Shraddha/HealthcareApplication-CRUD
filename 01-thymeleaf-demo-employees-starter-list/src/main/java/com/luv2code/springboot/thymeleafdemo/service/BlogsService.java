package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Blogs;

public interface BlogsService {

	List<Blogs> getAllBlog();

	Blogs saveBlogs(Blogs blogs);
	
	Blogs getBlogsById(int id);
	
	//Blogs updateBlogs(Blogs Blogs);

	void deleteBlogsById(int id);

	Blogs findById(int theId);

	
	
	
}
