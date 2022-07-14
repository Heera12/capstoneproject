package com.wipro.capstoneproject.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.wipro.capstoneproject.dto.QuestionDTO;
import com.wipro.capstoneproject.entity.Questions;
import com.wipro.capstoneproject.repository.IQuestionRepository;

@Service
public class QuestionServiceImp implements IQuestionService {

	@Autowired
	IQuestionRepository repo;

	public static boolean validateQuestion(QuestionDTO question) {

		boolean flag = false;
		if (question.getQuestionId() >= 1 && question.getTopic().length()>2  && question.getQuestion().length() >= 4) {
			flag = true;
		}

		return flag;

	}

	@Override
	public Questions addQuestion(QuestionDTO questionDTO) {
 
		Questions question = new Questions();
		question.setQuestionId(questionDTO.getQuestionId());
		question.setQuestion(questionDTO.getQuestion());
		question.setTopic(questionDTO.getTopic());

		return repo.save(question);
	}

	@Override
	public Questions updateQuestion(QuestionDTO questionDTO) {
		
		Questions question = new Questions();
		question.setQuestionId(questionDTO.getQuestionId());
		question.setQuestion(questionDTO.getQuestion());
		question.setTopic(questionDTO.getTopic());
		
		return repo.save(question);
		
	}

	@Override
	public List<Questions> getQuestionByWord(String question) {
		
		return repo.findAll();
	}

	@Override
	public ResponseEntity<String> deleteQuestionById(long qid) {
		repo.deleteById(qid);
		return new ResponseEntity<String>("Question wad deleted",HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<String> approveQuestionsByAdmin(long qid) {
		
		Questions question = repo.findById(qid).orElseThrow();
		if(question!= null) {
			question.setStatus(true);
			repo.save(question);
		}
		return new ResponseEntity<String>("Question Approve Sucessfully",HttpStatus.ACCEPTED);
		
		
		
	}

	@Override
	public List<Questions> findQuestionByKeyword(String keyword) {
		
		return repo.findQuestionByKeyword(keyword);
	}

	@Override
	public ResponseEntity<String> addQuestionsWithMail(QuestionDTO questionDTO) {
		addQuestionsWithMail(questionDTO);
		return new ResponseEntity<String>("User was added the question",HttpStatus.ACCEPTED);
	}

	@Override
	public List<Questions> getall() {
		
		return repo.findAll();
	}
	

	
	

	
	

}