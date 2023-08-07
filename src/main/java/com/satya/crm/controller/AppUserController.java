package com.satya.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.satya.crm.models.AppUser;
import com.satya.crm.models.Message;
import com.satya.crm.service.AppUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppUserController {

	@Autowired
	private AppUserService appAppUserService;

	@PostMapping("/addAppUser")
	public AppUser addAppUser(@RequestBody AppUser appAppUser) {
		return appAppUserService.saveAppUser(appAppUser);
	}

	// handler for registor appAppUser
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerAppUser(@Valid @ModelAttribute("appUser") AppUser appUser,BindingResult bindingResult,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,HttpSession session) {
		try {
			if (!agreement) {
				System.out.println("you have not agreed terms and conditions");
				throw new Exception("You haven't Agreeed Terms and Conditions");
			}
			if(bindingResult.hasErrors()) {
				System.err.println("Result : "+ bindingResult.toString());
				model.addAttribute("appUser",appUser);
				return "signup";
			}
				appUser.setRole("ROLE_USER");
				appUser.setEnabled(true);
				appUser.setImageUrl("default.png");
				
				System.err.println("Agreement => "+agreement);
				System.err.println("AppUser"+appUser);
				
				AppUser savedAppUser = appAppUserService.saveAppUser(appUser);
				model.addAttribute("appUser", new AppUser());
				session.setAttribute("message",new Message("Successfully Registered ", "alert-success"));
				return "signup";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("appUser",appUser);
			session.setAttribute("message", new Message("Something went wrong !!\n"+e.getMessage(), "alert-danger"));
			return "signup";
		}
	}
}
