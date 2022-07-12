package com.wipro.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.Questions;
import com.wipro.capstoneproject.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	public User findByUname(String uname);

	public Questions save(Questions question);
	
}
