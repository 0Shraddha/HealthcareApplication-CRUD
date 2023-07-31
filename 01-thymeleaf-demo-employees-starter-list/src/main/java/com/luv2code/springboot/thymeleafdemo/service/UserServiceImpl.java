package com.luv2code.springboot.thymeleafdemo.service;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.UserRepository;
import com.luv2code.springboot.thymeleafdemo.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
		

		private UserRepository userRepository;
		
		
		public UserServiceImpl(UserRepository userRepository) {
			super();
			this.userRepository = userRepository;
		}


		@Override
		public User saveUser(User user) {
			return userRepository.save(user);
		}
		

}
