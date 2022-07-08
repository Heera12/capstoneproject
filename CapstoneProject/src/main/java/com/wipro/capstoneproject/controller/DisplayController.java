package com.wipro.capstoneproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class DisplayController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String displayPage() {
    	return "home";
        }

}
