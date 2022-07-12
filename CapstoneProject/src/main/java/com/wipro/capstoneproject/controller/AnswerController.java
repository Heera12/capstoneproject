package com.wipro.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.wipro.capstoneproject.dto.AnswersDTO;
import com.wipro.capstoneproject.entity.Answers;
import com.wipro.capstoneproject.service.AnswerServiceImpl;
import com.wipro.capstoneproject.service.EmailServiceImpl;

@RestController
@RequestMapping("/cap/project/answers")
public class AnswerController {
	
	
	@Autowired
	AnswerServiceImpl service;
	
	@Autowired
	EmailServiceImpl emailService;
	
	@PostMapping("/add")
	public Answers addAnswers(@RequestBody AnswersDTO answersDTO) {
		
		Answers ans= service.addAnswers(answersDTO);
		emailService.sendSimpleMail(ans.convertDto(ans));
		return ans;
		
		
	}
	
	@PutMapping("/update")
	public Answers updateAnswers(@RequestBody AnswersDTO answersDTO) {
		return service.updateAnswers(answersDTO);
	}
	
	@DeleteMapping("/delete/{answerId}")
	public ResponseEntity<String> deleteAnswerById(@PathVariable long answerId){
		return service.deleteAnswerById(answerId);
	}
	
	@GetMapping("/get-all/{questionId}")
	public List<Answers> getAllAnsersByQuestionId(long questionId){
		return service.getAllAnsersByQuestionId(questionId);
	}
	
	@PostMapping("/add/email")
	public ResponseEntity<String> addAnswer(@RequestBody AnswersDTO answersDTO){
		
		Answers ans= service.addAnswers(answersDTO);
		emailService.sendSimpleMail(ans.convertDto(ans));
		return new ResponseEntity<String>("Answer was added email was Sent sucessfully",HttpStatus.ACCEPTED);
		
	}

}
