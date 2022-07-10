package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.UserDTO;
import com.wipro.capstoneproject.entity.User;
import com.wipro.capstoneproject.exception.PasswordDoesNotMatchException;
import com.wipro.capstoneproject.exception.UserNotFoundException;
import com.wipro.capstoneproject.repository.IUserRepository;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	IUserRepository repo;

	@Override
	public User login(UserDTO userDTO)
	{
		
		System.out.println("****** name: "+ userDTO.getUname() + "  password: " + userDTO.getPassword());
		User user = repo.findByUname(userDTO.getUname());
		
		
		System.out.println("************************* user is " + user);
		if(null == user) {
			throw new UserNotFoundException("user not found");
		}
		
		if(!user.getPassword().equalsIgnoreCase(userDTO.getPassword())) {
			throw new PasswordDoesNotMatchException("password does not match");
		}
		
		return user;
	}
	

	
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
		return repo.findById(uid).orElseThrow();
	}

	@Override
	public boolean deleteUserById(long uid) {
		repo.deleteById(uid);
		return true;

	}

	@Override
	public User getUserByName(String uname) {
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
