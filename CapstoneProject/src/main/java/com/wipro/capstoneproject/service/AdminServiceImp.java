package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AdminDTO;

import com.wipro.capstoneproject.dto.QuestionDTO;
import com.wipro.capstoneproject.entity.Admin;

import com.wipro.capstoneproject.entity.Questions;
import com.wipro.capstoneproject.repository.IAdminRepository;

import com.wipro.capstoneproject.repository.IQuestionRepository;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	IAdminRepository repo;

	@Autowired
	IQuestionRepository questionRepo;

	/*
	 * @Autowired IAnswersRepository answerRepo;
	 */

	@Override
	public Admin addAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setId(adminDTO.getId());
		admin.setName(adminDTO.getName());
		admin.setEmail(adminDTO.getEmail());
		admin.setPassword(adminDTO.getPassword());

		return repo.save(admin);
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setId(adminDTO.getId());
		admin.setName(adminDTO.getName());
		admin.setEmail(adminDTO.getEmail());
		admin.setPassword(adminDTO.getPassword());

		return repo.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}

	@Override
	public Admin getAdminById(long aid) {
		return repo.findById(aid).orElse(new Admin());
	}

	@Override
	public Admin getAdminByName(String name) {
		return repo.findAdminByName(name);
	}

	@Override
	public ResponseEntity<String> deleteAdminById(long aid) {
		repo.deleteById(aid);
		return new ResponseEntity<String>("Record Deleted Sucessfully", HttpStatus.ACCEPTED);
	}

	public static boolean validateAdmin(AdminDTO adminDTO) {

		boolean flag = false;

		if (adminDTO.getName().length() > 4 && adminDTO.getEmail().length() > 4
				&& adminDTO.getPassword().length() > 4) {

			flag = true;
		}

		return flag;

	}

	@Override
	public Questions addQuestion(QuestionDTO questionDTO) {

		Questions question = new Questions();
		question.setQuestionId(questionDTO.getQuestionId());
		question.setQuestion(questionDTO.getQuestion());
		question.setTopic(questionDTO.getTopic());

		return questionRepo.save(question);
	}

	@Override
	public Questions updateQuestion(QuestionDTO questionDTO) {

		Questions question = new Questions();
		question.setQuestionId(questionDTO.getQuestionId());
		question.setQuestion(questionDTO.getQuestion());
		question.setTopic(questionDTO.getTopic());

		return questionRepo.save(question);

	}

}
