package com.wipro.capstoneproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wipro.capstoneproject.dto.QuestionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "QUESTIONS_TABLE")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
<<<<<<< HEAD
=======
	private String topic;
>>>>>>> 88cd08c8d2b8c0402901be7e054897306cb6c13b
	private String question;
	private boolean status;
	
	public QuestionDTO converDto(Questions question) {
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setQuestionId(question.getQuestionId());
		questionDTO.setQuestion(question.getQuestion());
		questionDTO.setTopic(question.getTopic());
		
		return questionDTO;
		
	}
	
}
