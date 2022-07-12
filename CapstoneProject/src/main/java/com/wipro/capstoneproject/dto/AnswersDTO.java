package com.wipro.capstoneproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswersDTO {
	
	
	private long answerId;
	private String answer;
	private long questionId;
}
