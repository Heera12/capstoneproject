package com.wipro.capstoneproject.dto;

import com.wipro.capstoneproject.entity.Admin;
import com.wipro.capstoneproject.entity.Login;
import com.wipro.capstoneproject.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponseDTO {

	public String loginStatus;
	
	public String loginMessage;
	
	
	public User user;
	
	public Admin admin;
	
	public Login loginDetails;
	
}
