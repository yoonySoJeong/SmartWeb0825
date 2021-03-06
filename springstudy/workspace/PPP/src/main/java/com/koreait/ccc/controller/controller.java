package com.koreait.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/user/login")
	public String login(@RequestParam("id")String id, @RequestParam("pw")String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "user/login";
	}
}
