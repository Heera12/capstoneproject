package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AnswersDTO;
import com.wipro.capstoneproject.entity.Answers;
import com.wipro.capstoneproject.repository.IAnswersRepository;

@Service
public class AnswerServiceImpl implements IAnswerService{
	
	@Autowired
	IAnswersRepository repo;

	@Override
	public Answers addAnswers(AnswersDTO answersDTO) {
		
		Answers answers = new Answers();
		answers.setAnswerId(answersDTO.getAnswerId());
		answers.setAnswer(answersDTO.getAnswer());
		answers.setQuestionId(answersDTO.getQuestionId());
		
		return repo.save(answers);
	}

	@Override
	public Answers updateAnswers(AnswersDTO answersDTO) {
		
		Answers answers = new Answers();
		answers.setAnswerId(answersDTO.getAnswerId());
		answers.setAnswer(answersDTO.getAnswer());
		answers.setQuestionId(answersDTO.getQuestionId());
		
		return repo.save(answers);
	}

	@Override
	public ResponseEntity<String> approveAnswerById(long answerId) {
		
		Answers answers = repo.findById(answerId).orElseThrow();
		if(answers!=null) {
			answers.setStatus(true);
			repo.save(answers);
		}
		return new ResponseEntity<String>("Answers was approved ",HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<String> deleteAnswerById(long answerId) {
		repo.deleteById(answerId);
		return new ResponseEntity<String>("Answer was deleted ",HttpStatus.ACCEPTED);
	}

	@Override
	public List<Answers> getAllAnsersByQuestionId(long questionId) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ResponseEntity<String> addAnswer(AnswersDTO answersDTO) {
		addAnswer(answersDTO);
		return new ResponseEntity<String>("Answer added sucessfully",HttpStatus.ACCEPTED) ;
	}

	@Override
	public List<Answers> getall() {
		return repo.findAll();
	}

	
	
	

}
