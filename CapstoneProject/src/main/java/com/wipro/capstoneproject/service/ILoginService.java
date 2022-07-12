package com.wipro.capstoneproject.service;

import com.wipro.capstoneproject.dto.AdminDTO;
import com.wipro.capstoneproject.dto.UserDTO;
import com.wipro.capstoneproject.entity.Login;

public interface ILoginService  {
	
	public Login addLoginUser(UserDTO user);

	public boolean deleteLoginUserById(long id);

	public Login addLoginAdmin(AdminDTO admin);


}
