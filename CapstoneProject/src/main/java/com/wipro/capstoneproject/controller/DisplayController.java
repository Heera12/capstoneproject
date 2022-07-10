package com.wipro.capstoneproject.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;

@Controller

@SessionAttributes("name")
public class DisplayController {
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	/*
	 * @GetMapping("/home") public String home(@RequestParam(required=true) String
	 * name, Model model) { model.addAttribute(name, model); return "home"; }
	 */
	
		/*
		 * @RequestMapping(value="/chat", method= RequestMethod.GET) public RestTemplate
		 * getApplication() {
		 * 
		 * RestTemplate rest = restTemplate.getForObject("http://localhost:8081",
		 * RestTemplate.class);
		 * 
		 * return rest ;
		 * 
		 * }
		 */
		
		  @RequestMapping(value = "/home", method = RequestMethod.GET)
		  public String displayPage() {
			  return "home"; 
			  }
		 

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
