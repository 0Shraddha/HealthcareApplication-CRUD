package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="blogs")
public class Blogs {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	
	
	
	// define constructors
	
	public Blogs() {
		
	}




	public Blogs(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}




	public Blogs(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "Blogs [id=" + id + ", title=" + title + ", description=" + description + "]";
	}



}











