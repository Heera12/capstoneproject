package com.wipro.capstoneproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneproject.service.QuestionServiceImp;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cap/project/quest")
public class QuestionController 
{
    @Autowired
    QuestionServiceImp service;
    
   }