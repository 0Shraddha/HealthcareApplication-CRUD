package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.thymeleafdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
