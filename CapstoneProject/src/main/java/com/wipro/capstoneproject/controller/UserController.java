package com.wipro.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneproject.entity.User;
import com.wipro.capstoneproject.service.IUserService;
import com.wipro.capstoneproject.service.UserServiceImp;

@RestController
public class UserController {

	@Autowired
	IUserService service;
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {

		User u1 = null;
		if (UserServiceImp.validateUser(user)) {

			u1 = service.addUser(user);

		}

		return u1;

	}

	@PutMapping("/update")
	public User update(@RequestBody User user) {

		User u1 = null;
		if (UserServiceImp.validateUser(user)) {

			u1 = service.updateUser(user);
		}
		return u1;
	}
	@GetMapping("/get/{uid}")
	public User getById(@PathVariable int uid) {
		return service.getUserById(uid);
		
	}
	@GetMapping("/get-uname/{uname}")
	public List<User> getById(@PathVariable String uname) {
		return service.getUserByName(uname);
		
	}

	@GetMapping("/getall")
	public List<User> getAll() {

		return service.getAllUsers();

	}
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<String> deleteById(@PathVariable long uid){
		return service.deleteUserById(uid);
		
	}

}