package com.wipro.capstoneproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstoneproject.entity.Answers;

@Repository
public interface IAnswersRepository  extends JpaRepository<Answers, Long>{

	

}
