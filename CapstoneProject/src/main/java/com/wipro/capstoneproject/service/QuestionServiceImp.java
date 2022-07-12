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
    

        public void save(Questions question) {
            repo.save(question);
        }
         
        public Questions get(long id) {
            return repo.findById(id).get();
        }
         
        public void delete(long id) {
            repo.deleteById(id);
        }

		@Override
		public List<Questions> listAll(String question) {
			// TODO Auto-generated method stub
			return null;
		}

    }