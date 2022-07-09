package com.wipro.capstoneproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.capstoneproject.entity.Questions;

public interface IQuestionRepository extends JpaRepository<Questions, Long> {

	@Query("SELECT q FROM Questions q WHERE q.question LIKE %?1%")
	public List<Questions> search(String keyword);

}

