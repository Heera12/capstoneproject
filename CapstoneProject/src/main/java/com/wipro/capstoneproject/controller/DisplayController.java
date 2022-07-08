package com.wipro.capstoneproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayController {
	
	@GetMapping("/home")
    public String viewHomePage() {
    	return "home";
        }

}
