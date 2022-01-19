package com.koreait.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login.do")
	public String login() {
		return "practiceFile/login";
	}
	
}
