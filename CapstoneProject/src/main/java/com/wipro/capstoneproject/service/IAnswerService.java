package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AnswersDTO;
import com.wipro.capstoneproject.entity.Answers;

@Service
public interface IAnswerService {
	
	public Answers addAnswers(AnswersDTO answersDTO);
	
	public Answers updateAnswers(AnswersDTO answersDTO);
	
	public ResponseEntity<String> approveAnswerById(long answerId);
	
	public ResponseEntity<String> deleteAnswerById(long answerId);
	
	public List<Answers> getAllAnsersByQuestionId(long questionId);
	
	public ResponseEntity<String> addAnswer(AnswersDTO answersDTO);

	public List<Answers> getall();

}
