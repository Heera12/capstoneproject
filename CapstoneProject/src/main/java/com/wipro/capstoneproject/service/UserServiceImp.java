package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.capstoneproject.dto.UserDTO;
import com.wipro.capstoneproject.entity.User;
import com.wipro.capstoneproject.repository.IUserRepository;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	IUserRepository repo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public User addUser(UserDTO userDTO) {

		User user = new User();
		user.setUid(userDTO.getUid());
		user.setUname(userDTO.getUname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		return repo.save(user);
	}

	@Override
	public User updateUser(UserDTO userDTO) {
		User user = new User();
		user.setUid(userDTO.getUid());
		user.setUname(userDTO.getUname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

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

	public static boolean validateUser(UserDTO user) {

		boolean flag = false;

		if (user.getUname().length() > 4 && user.getEmail().length() > 4 && user.getPassword().length() >= 4) {

			flag = true;
		}

		return flag;

	}

}
