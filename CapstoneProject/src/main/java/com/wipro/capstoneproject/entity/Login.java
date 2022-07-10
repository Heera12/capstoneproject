package com.wipro.capstoneproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LOGIN_TABLE")
public class Login {
	

	@Id
	private long uid;

	@Column(name = "User_Name")
	private String uname;
	
	@Column(name = "login_status")
	private String loginStatus;
	
	@Column(name = "login_time")
	private String loginTime;

}