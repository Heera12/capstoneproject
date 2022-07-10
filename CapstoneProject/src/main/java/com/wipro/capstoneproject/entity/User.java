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
@Table(name = "USER_TABLE")
public class User {

	@Id
	private long uid;
	@Column(name = "User_Name")
	private String uname;
	@Column(name = "User_Email")
	private String email;
	@Column(name = "User_Password")
	private String password;

}