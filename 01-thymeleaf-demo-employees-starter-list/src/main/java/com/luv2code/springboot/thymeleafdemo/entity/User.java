package com.luv2code.springboot.thymeleafdemo.entity;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "role")
	private String role;

	@Column(name = "username")
	private String username;

	@NaturalId(mutable = true)
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public User() {
		
	}

	public User(String fullname, String role, String username, String email, String password) {
		super();
		this.fullname = fullname;
		this.role = role;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(int id, String fullname, String role, String username, String email, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.role = role;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", role=" + role + ", username=" + username + ", email="
				+ email + ", password=" + password + "]";
	}
	
}