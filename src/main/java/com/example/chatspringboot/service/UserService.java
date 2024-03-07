package com.example.chatspringboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatspringboot.entity.User;
import com.example.chatspringboot.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean usernameExists(String username) {
		if(userRepository.findUserByUsername(username) == null) {
			return false;
			
		} else {
			return true;
		}
	}
	
	public User registerUser(String username) {
		if(usernameExists(username)) {
			return null;
		} else {
			User newUser = new User(username);
			return userRepository.save(newUser);
		}
	}

}
