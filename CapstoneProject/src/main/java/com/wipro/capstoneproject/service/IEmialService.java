package com.wipro.capstoneproject.service;

import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AnswersDTO;
import com.wipro.capstoneproject.dto.QuestionDTO;


@Service
public interface IEmialService {
	
	
	
	//public String sendMailWithAttachment(EmailDetails details);

	public String sendSimpleMail(QuestionDTO questionDTO);
	
	public String sendSimpleMail(AnswersDTO answersDTO);
	
	

}
