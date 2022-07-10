package com.wipro.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.Login;

public interface ILoginRepository extends JpaRepository<Login, Long> {

	
}

