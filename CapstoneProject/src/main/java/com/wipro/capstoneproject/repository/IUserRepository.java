package com.wipro.capstoneproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	public List<User> findByUname(String uname);

}
