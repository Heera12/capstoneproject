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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneproject.dto.AdminDTO;
import com.wipro.capstoneproject.entity.Admin;
import com.wipro.capstoneproject.service.AdminServiceImp;
import com.wipro.capstoneproject.service.IAnswerService;
import com.wipro.capstoneproject.service.IQuestionService;

@RestController
@RequestMapping("/cap/project/admin")
public class AdminController {

	@Autowired
	AdminServiceImp service;

	@Autowired
	IQuestionService questionService;
	
	@Autowired
	IAnswerService answerService;

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody AdminDTO adminDTO) {

		Admin a1 = null;
		if (AdminServiceImp.validateAdmin(adminDTO)) {

			a1 = service.addAdmin(adminDTO);

		}

		return a1;

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
