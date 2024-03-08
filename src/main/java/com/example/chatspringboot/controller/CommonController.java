package com.example.chatspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chatspringboot.entity.User;
import com.example.chatspringboot.service.UserService;

@Controller
public class CommonController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getHomepage() {
		return "index";
	}
	
	@GetMapping("/start")
	public String getStartChatPage() {
		return "start";
	}
	
	@PostMapping("/start")
	public String startChat(Model model, @ModelAttribute("user") User user, @RequestParam("cpassword") String cpassword) {
		User newUser = userService.registerUser(user.getUsername());
		
		if(newUser == null) {
			model.addAttribute("errmsg", "username already exists. Choose a new one.");
			return "start";
		} else {
			model.addAttribute("msg", "You may now start chat.");
			model.addAttribute("username", newUser.getUsername());
			return "chat";
		}
	}
	
	@GetMapping("/chat")
	public String getChatPage() {
		return "chat";
	}
}
