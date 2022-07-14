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

	public Admin addAdmin(AdminDTO adminDTO);

	public List<Admin> getAllAdmin();

	public Admin getAdminById(long aid);

	public Admin updateAdmin(AdminDTO adminDTO);

	public Admin getAdminByName(String name);

	public ResponseEntity<String> deleteAdminById(long aid);

	public Questions addQuestion(QuestionDTO questionDTO);

	public Questions updateQuestion(QuestionDTO questionDTO);

	
	public Admin login(AdminDTO adminDTO);

}
