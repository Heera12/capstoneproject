package com.wipro.capstoneproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneproject.dto.QuestionDTO;
import com.wipro.capstoneproject.entity.Questions;
import com.wipro.capstoneproject.service.EmailServiceImpl;
import com.wipro.capstoneproject.service.QuestionServiceImp;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cap/project/quest")
public class QuestionController 
{
    @Autowired
    QuestionServiceImp service;
    
    @Autowired
    EmailServiceImpl emailService;
    
    @PostMapping("/add")
    public Questions addQuestion(@RequestBody QuestionDTO questionDTO) {
    	Questions q1 = null;
    	if(QuestionServiceImp.validateQuestion(questionDTO)) {
    		q1 = service.addQuestion(questionDTO);
    	}
    	emailService.sendSimpleMail(q1.converDto(q1));
		return q1;
    	
    }
    
    @PutMapping("/update")
    public Questions updateQuestion(@RequestBody QuestionDTO questionDTO) {
    	Questions q1 = null;
    	if(QuestionServiceImp.validateQuestion(questionDTO)) {
    		q1 = service.updateQuestion(questionDTO);
    	}
		return q1;
    	
    }
    
    @GetMapping("/get/{question}")
    public List<Questions> getQuestionByWord(@PathVariable String question) {
		return service.getQuestionByWord(question);
    	
    }
    
    @DeleteMapping("/delete/{qid}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable long qid){
    	return service.deleteQuestionById(qid);
    }
    
    @RequestMapping(path="/search/{keyword}")
    public List<Questions> findQuestionByKeyword(@PathVariable String keyword){
    	List<Questions> questions = null;
    	if(keyword!=null) {
    		questions=service.findQuestionByKeyword(keyword);
    		if(questions!=null) {
    			return questions;
    		}
    	}
    	return null;
    	
    }
    
    @PostMapping("/add/mail")
    public ResponseEntity<String> addQuestionsWithMail(@RequestBody QuestionDTO questionDTO){
    	
    	Questions q1 = service.addQuestion(questionDTO);
    	emailService.sendSimpleMail(q1.converDto(q1));
    	return new ResponseEntity<String>("User was added the question",HttpStatus.ACCEPTED);
    }
    
    
   }
