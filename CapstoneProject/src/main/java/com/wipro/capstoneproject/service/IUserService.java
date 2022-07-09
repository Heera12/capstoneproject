package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.capstoneproject.dto.UserDTO;
import com.wipro.capstoneproject.entity.User;

public interface IUserService  {
	
	public User addUser(UserDTO user);

	public User updateUser(UserDTO userDTO);

	public List<User> getAllUsers();

	public User getUserById(long uid);

	public ResponseEntity<String> deleteUserById(long uid);

	public List<User> getUserByName(String uname);

}
