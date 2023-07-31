package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

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
	
//	@ManyToOne // Many books can be written by one author
//    @JoinColumn(name = "patient_id") // Foreign key column name in the Book table
//    private Doctor doctor;;
	
	@Column(name="doctor")
	private String doctor;	
	
	@Column(name="date")
	private String date;
	
	@Column(name="disease")
	private String disease;
	
	
	// define constructors
	
	public Patient() {
		
	}


	public Patient(int id, String fullName, String email, String phone, String date, String disease) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
//		this.doctor=doctor;
		this.date = date;
		this.disease = disease;
	}


	public Patient(String fullName, String email, String phone, String date, String disease) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
//		this.doctor=doctor;
		this.date = date;
		this.disease = disease;
	}

	// define getter/setter
	

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
	
//	public String getDoctor() {
//		return doctor;
//	}
//
//
//	public void setDoctor(String doctor) {
//		this.doctor = doctor;
//	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}

	// define toString

	@Override
	public String toString() {
		return "Patient [id=" + id +
				", fullName=" + fullName + 
				", email=" + email + 
				", phone=" + phone +
				//",doctor=" + doctor +
				", date="+ date + 
				", disease=" + disease + 
				"]";
	}


}











