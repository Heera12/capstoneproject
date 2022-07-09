package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.entity.Questions;

@Service
public interface IQuestionService {

    public List<Questions> listAll(String keyword);
    public void save(Questions question);
    public Questions get(long id);
    public void delete(long id);


}
