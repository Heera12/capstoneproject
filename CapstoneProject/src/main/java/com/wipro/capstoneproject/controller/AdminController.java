package com.wipro.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneproject.dto.AdminDTO;
import com.wipro.capstoneproject.dto.LoginDTO;
import com.wipro.capstoneproject.dto.LoginResponseDTO;
import com.wipro.capstoneproject.entity.Admin;
import com.wipro.capstoneproject.entity.Login;
import com.wipro.capstoneproject.exception.PasswordDoesNotMatchException;
import com.wipro.capstoneproject.exception.UserNotFoundException;
import com.wipro.capstoneproject.service.AdminServiceImp;

import com.wipro.capstoneproject.service.LoginServiceImpl;
import com.wipro.capstoneproject.service.IAnswerService;
import com.wipro.capstoneproject.service.IQuestionService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cap/project/admin")
public class AdminController {

	@Autowired
	AdminServiceImp service;
	
	@Autowired
	LoginServiceImpl loginService;
	
	@Autowired
	IQuestionService questionService;
	
	@Autowired
	IAnswerService answerService;
	
	@PostMapping("/login")
	public LoginResponseDTO login(@RequestBody AdminDTO admin)
	{
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		
		try {
			
		    Admin a = service.login(admin);
			
			loginResponseDTO.setLoginStatus("success");
			loginResponseDTO.setLoginMessage("login success");
			loginResponseDTO.setAdmin(a);
			
			Login login = loginService.addLoginAdmin(admin);
			
			loginResponseDTO.setLoginDetails(login);
			
			
			System.out.println("***** controller **** user  : " + a);
			System.out.println("***** controller **** login  : " + login);
			
		} catch(UserNotFoundException excep) {
			loginResponseDTO.setLoginStatus("failed");
			loginResponseDTO.setLoginMessage("login failed, Admin not found");
		} catch(PasswordDoesNotMatchException excep) {
			loginResponseDTO.setLoginStatus("failed");
			loginResponseDTO.setLoginMessage("login failed, password does not match");
		}
		
		
		return loginResponseDTO;
		
	}


	@PostMapping("/add")
	public Admin addAdmin(@RequestBody AdminDTO adminDTO) {

		Admin a1 = null;
		if (AdminServiceImp.validateAdmin(adminDTO)) {

			a1 = service.addAdmin(adminDTO);

		}

		return a1;

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


	@PutMapping("/update")
	public Admin update(@RequestBody AdminDTO adminDTO) {

		Admin a1 = null;
		if (AdminServiceImp.validateAdmin(adminDTO)) {

			a1 = service.updateAdmin(adminDTO);
		}
		return a1;
	}

	@GetMapping("/get/{aid}")
	public Admin getAdminById(@PathVariable long aid) {
		return service.getAdminById(aid);

	}

	@GetMapping("/get-aname/{name}")
	public Admin getAdminByName(@PathVariable String name) {
		return service.getAdminByName(name);

	}

	@GetMapping("/getall")
	public List<Admin> getAll() {

		return service.getAllAdmin();

	}

	@DeleteMapping("/delete/{aid}")
	public ResponseEntity<String> deleteAdminById(@PathVariable long aid) {
		return service.deleteAdminById(aid);

	}

	@PostMapping("/question/approval/{qid}")
	public ResponseEntity<String> approveQuestionById(@PathVariable long qid) {
		return questionService.approveQuestionsByAdmin(qid);

	}
	
	@PostMapping("/answer/approval/{answerId}")
	public ResponseEntity<String> approveAnswerById(@PathVariable long answerId){
		return answerService.approveAnswerById(answerId);
	}

}
