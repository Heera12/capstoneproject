package com.wipro.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.Questions;

public interface IQuestionRepository extends JpaRepository<Questions, Long> {


}

