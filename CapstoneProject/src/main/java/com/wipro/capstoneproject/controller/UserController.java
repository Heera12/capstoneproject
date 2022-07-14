package com.wipro.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneproject.dto.LoginDTO;
import com.wipro.capstoneproject.dto.LoginResponseDTO;
import com.wipro.capstoneproject.dto.UserDTO;
import com.wipro.capstoneproject.entity.Login;
import com.wipro.capstoneproject.entity.User;
import com.wipro.capstoneproject.exception.PasswordDoesNotMatchException;
import com.wipro.capstoneproject.exception.UserNotFoundException;
import com.wipro.capstoneproject.service.ILoginService;
import com.wipro.capstoneproject.service.IUserService;
import com.wipro.capstoneproject.service.UserServiceImp;

@RestController
@RequestMapping("/cap/project/users")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	IUserService service;
	
	@Autowired
	ILoginService loginService;
	
	@PostMapping("/login")
	public LoginResponseDTO login(@RequestBody UserDTO user)
	{
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		
		try {
			
			User u = service.login(user);
			
			loginResponseDTO.setLoginStatus("success");
			loginResponseDTO.setLoginMessage("login success");
			loginResponseDTO.setUser(u);
			
			Login login = loginService.addLoginUser(user);
			
			loginResponseDTO.setLoginDetails(login);
			
			
			System.out.println("***** controller **** user  : " + u);
			System.out.println("***** controller **** login  : " + login);
			
		} catch(UserNotFoundException excep) {
			loginResponseDTO.setLoginStatus("failed");
			loginResponseDTO.setLoginMessage("login failed, user not found");
		} catch(PasswordDoesNotMatchException excep) {
			loginResponseDTO.setLoginStatus("failed");
			loginResponseDTO.setLoginMessage("login failed, password does not match");
		}
		
		
		return loginResponseDTO;
		
	}
	
	@PostMapping("/logout")
	public LoginResponseDTO logout(@RequestBody LoginDTO loginDTO) {
		
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		
		try {
			
			loginService.deleteLoginUserById(loginDTO.getUid());
			
			loginResponseDTO.setLoginStatus("success");
			loginResponseDTO.setLoginMessage("log out successful");
			
		} catch(Exception excep) {
			loginResponseDTO.setLoginStatus("failed");
			loginResponseDTO.setLoginMessage("logout failed");
			
		}
		
		return loginResponseDTO;
	}

	@PostMapping("/add")
	public User add(@RequestBody UserDTO user) {

		User u1 = null;
		if (UserServiceImp.validateUser(user)) {

			u1 = service.addUser(user);

		}

		return u1;

	}

	@PutMapping("/update")
	public User update(@RequestBody UserDTO user) {

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
	public User getById(@PathVariable String uname) {
		return service.getUserByName(uname);

	}

	@GetMapping("/getall")
	public List<User> getAll() {

		return service.getAllUsers();

	}

	@DeleteMapping("/delete/{uid}")
	public boolean deleteById(@PathVariable long uid) {
		return service.deleteUserById(uid);

	}

}