package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ambulance")
public class Ambulance {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hospital")
	private String hospital;
	
	@Column(name="contact")
	private String contact;
	
	
	@Column(name="location")
	private String location;
	
	
	// define constructors
	
	public Ambulance() {
		
	}


	public Ambulance(int id, String hospital, String contact, String location) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.contact = contact;
		this.location = location;
	}


	public Ambulance(String hospital, String contact, String location) {
		super();
		this.hospital = hospital;
		this.contact = contact;
		this.location = location;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHospital() {
		return hospital;
	}


	public void setHospital(String hospital) {
		this.hospital = hospital;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	


}











