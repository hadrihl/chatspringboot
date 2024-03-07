package com.example.chatspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/")
	public String getHomepage() {
		return "index";
	}
	
	@GetMapping("/start")
	public String getStartChatPage() {
		return "start";
	}
}
