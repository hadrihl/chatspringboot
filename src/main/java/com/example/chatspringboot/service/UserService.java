package com.example.chatspringboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.chatspringboot.entity.User;
import com.example.chatspringboot.repository.RoleRepository;
import com.example.chatspringboot.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public boolean usernameExists(String username) {
		if(userRepository.findUserByUsername(username) == null) {
			return false;
			
		} else {
			return true;
		}
	}
	
	public User registerUser(User user) {
		if(usernameExists(user.getUsername())) {
			return null;
		} else {
			User newUser = new User();
			newUser.setUsername(user.getUsername());
			newUser.setEmail(user.getEmail());
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //salted
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			
			newUser.addRoles(roleRepository.findById(1).get()); // default role: USER
			return userRepository.save(newUser);
		}
	}

}
