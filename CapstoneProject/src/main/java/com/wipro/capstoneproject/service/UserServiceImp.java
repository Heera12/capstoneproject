package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.entity.User;
import com.wipro.capstoneproject.repository.IUserRepository;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	IUserRepository repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User getUserById(long uid) {
		return repo.findById(uid).orElse(new User());
	}

	@Override
	public ResponseEntity<String> deleteUserById(long uid) {
		repo.deleteById(uid);
		return new ResponseEntity<String>("Record Deleted Sucessfully", HttpStatus.ACCEPTED);

	}

	@Override
	public List<User> getUserByName(String uname) {
		return repo.findByUname(uname);
	}

	public static boolean validateUser(User user) {

		boolean flag = false;

		if (user.getUname().length() > 5 && user.getPassword().length() >= 5) {

			flag = true;
		}

		return flag;

	}

}
