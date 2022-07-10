package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.entity.Questions;
import com.wipro.capstoneproject.repository.IQuestionRepository;

@Service
public class QuestionServiceImp implements IQuestionService{

	@Autowired
    IQuestionRepository repo;
    
         
        public List<Questions> listAll(String keyword) {
            if (keyword != null) {
                return repo.search(keyword);
            }
            return repo.findAll();
        }


        public void save(Questions question) {
            repo.save(question);
        }
         
        public Questions get(long id) {
            return repo.findById(id).get();
        }
         
        public void delete(long id) {
            repo.deleteById(id);
        }
         
    }