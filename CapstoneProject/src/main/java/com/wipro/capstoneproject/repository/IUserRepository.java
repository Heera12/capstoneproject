package com.wipro.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstoneproject.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
