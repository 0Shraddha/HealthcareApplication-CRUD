package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="phone")
	private String phone;
	
		
	@Column(name="specialize")
	private String specialize;
	
	@Column(name="schedule")
	private String schedule;
	
	
	// define constructors
	
	public Doctor() {
		
	}


	public Doctor(int id, String fullName, String email, String phone, String specialize, String schedule) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.specialize = specialize;
		this.schedule = schedule;
	}


	public Doctor(String fullName, String email, String phone, String specialize, String schedule) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.specialize = specialize;
		this.schedule = schedule;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getSpecialize() {
		return specialize;
	}


	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}


	public String getSchedule() {
		return schedule;
	}


	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", specialize="
				+ specialize + ", schedule=" + schedule + "]";
	}


	


}











