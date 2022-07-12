package com.wipro.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.Questions;

public interface IQuestionRepository extends JpaRepository<Questions, Long> {
<<<<<<< HEAD


=======
	
	
	@Query(value="select * from questions_table where question like %:keyword% or topic like %:keyword%",nativeQuery=true)
	List<Questions> findQuestionByKeyword(String keyword);
>>>>>>> 88cd08c8d2b8c0402901be7e054897306cb6c13b
}

