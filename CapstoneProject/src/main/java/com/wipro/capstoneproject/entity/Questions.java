package com.wipro.capstoneproject.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String type;
	private String level;
	private Date createdAt;
	private Date updatedAt;
	private String question;
	
}
