package com.wipro.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AnswersDTO;
import com.wipro.capstoneproject.dto.QuestionDTO;
import com.wipro.capstoneproject.entity.Admin;



@Service
public class EmailServiceImpl implements IEmialService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	IAdminService adminService;

	@Value("${spring.mail.username}")
	private String sender;
	
	

	@Override
	public String sendSimpleMail(QuestionDTO questionDTO) {
		try {

			// Creating a simple mail message for question
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			StringBuilder toEmail = new StringBuilder();
			List<Admin> adminList=adminService.getAllAdmin();
			adminList.stream().forEach(admin ->{
				toEmail.append(admin.getEmail()).append(",");
			}); 

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(toEmail.toString());
			mailMessage.setText(questionDTO.getQuestion());
			mailMessage.setSubject("User created question");

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	

	@Override
	public String sendSimpleMail(AnswersDTO answersDTO) {
		try {
			
			// Creating a simple mail message for answer
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			StringBuilder toEmail = new StringBuilder();
			List<Admin> adminList=adminService.getAllAdmin();
			adminList.stream().forEach(admin ->{
				toEmail.append(admin.getEmail()).append(",");
			}); 

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(toEmail.toString());
			mailMessage.setText(answersDTO.getAnswer());
			mailMessage.setSubject("User uploaded answers");

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
			
		}
		catch(Exception e){			
			return "Error While Sending mail";
		}
		
	}

	

}
