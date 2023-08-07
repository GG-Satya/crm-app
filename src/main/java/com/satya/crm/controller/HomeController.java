package com.satya.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satya.crm.models.AppUser;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("title","Home (CRM)");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model){
		model.addAttribute("title","About-CRM");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model){
		model.addAttribute("title", "Registration (CRM)");
		model.addAttribute("appUser",new AppUser());
		return "signup";
	}
}
