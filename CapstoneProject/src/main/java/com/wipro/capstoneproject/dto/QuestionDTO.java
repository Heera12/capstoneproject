package com.wipro.capstoneproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionDTO {
	
	private long questionId;
	private String topic;
	private String question;
	private boolean status;
	
}
