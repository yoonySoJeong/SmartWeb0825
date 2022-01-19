package com.koreait.ex09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex09.command.ContactCommand;

@Controller
@RequestMapping(value = "contact")
public class ContactController {
	
	private ContactCommand service;
	
	//findAllContact
	@GetMapping("findAllContact")
	public String findAllContact(Model model) {
		service.execute(model);
		return "contact/list";
	}
	
	// contactPage
	@GetMapping("contactPage")
	public String contactPage() {
		return "redirect:addContact";
	}
	
	// addContact
	public String addContact() {
		return "addContact";
	}
	
	// updateContact
	
	
	// deleteContact
	
}
