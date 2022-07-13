package com.wipro.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.Questions;

public interface IQuestionRepository extends JpaRepository<Questions, Long> {

	@Query(value="select * from questions_table where question like %:keyword% or topic like %:keyword%",nativeQuery=true)
	List<Questions> findQuestionByKeyword(String keyword);
}

