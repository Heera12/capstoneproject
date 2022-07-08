package com.wipro.capstoneproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/home")
	public String viewHomePage() {
		return "Index.html";
	}
}