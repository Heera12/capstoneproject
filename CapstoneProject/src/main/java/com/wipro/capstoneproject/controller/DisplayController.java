package com.wipro.capstoneproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

@SessionAttributes("name")
@CrossOrigin(origins="http://localhost:4200")
public class DisplayController {
	
	
		
		 

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String displayPage() {
		return "home";
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userPage() {
		return "users";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage() {
		return "signup";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchPage() {
		return "search";
	}


}
