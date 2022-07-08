package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.capstoneproject.entity.User;

public interface IUserService  {

	public User updateUser(User user);

	public List<User> getAllUsers();

	public User getUserById(long uid);

	public ResponseEntity<String> deleteUserById(long uid);

	public List<User> getUserByName(String uname);

	public User addUser(User user);

}
