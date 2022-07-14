package com.wipro.capstoneproject.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.wipro.capstoneproject.dto.QuestionDTO;
import com.wipro.capstoneproject.entity.Questions;

@Service
public interface IQuestionService {

    public Questions addQuestion(QuestionDTO questionDTO);
    
    public Questions updateQuestion(QuestionDTO questionDTO);
    
    public List<Questions> getall();
    
    public List<Questions> getQuestionByWord(String question);

    public ResponseEntity<String> deleteQuestionById(long qid);
    
    public ResponseEntity<String> approveQuestionsByAdmin(long qid);
    
    public List<Questions> findQuestionByKeyword(String keyword);
    
    public ResponseEntity<String> addQuestionsWithMail(QuestionDTO questionDTO);
}
