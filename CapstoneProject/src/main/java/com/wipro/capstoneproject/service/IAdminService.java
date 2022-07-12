package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AdminDTO;

import com.wipro.capstoneproject.dto.QuestionDTO;
import com.wipro.capstoneproject.entity.Admin;

import com.wipro.capstoneproject.entity.Questions;

@Service
public interface IAdminService {

	public List<Admin> getAllAdmin();

	public Admin getAdminById(long aid);

	public Admin updateAdmin(AdminDTO adminDTO);

	public Admin getAdminByName(String name);

	public ResponseEntity<String> deleteAdminById(long aid);

<<<<<<< HEAD
	public Admin login(AdminDTO adminDTO);

	public Admin addAdmin(AdminDTO adminDTO);
=======
	public Questions addQuestion(QuestionDTO questionDTO);

	public Questions updateQuestion(QuestionDTO questionDTO);
>>>>>>> 88cd08c8d2b8c0402901be7e054897306cb6c13b

}
