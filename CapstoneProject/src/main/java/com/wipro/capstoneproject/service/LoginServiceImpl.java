package com.wipro.capstoneproject.service;

import java.time.LocalDate;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.dto.AdminDTO;
import com.wipro.capstoneproject.dto.UserDTO;
import com.wipro.capstoneproject.entity.Login;
import com.wipro.capstoneproject.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository repo;
	
	
	@Override
	public Login addLoginUser(UserDTO user) {
		
		Login login = new Login();
		
		String now = LocalDate.now() + "";
		Random random = new Random();   
		
		long randomNum = Math.abs( random.nextLong());
		
		login.setUid(randomNum);
		login.setUname(user.getUname());
		login.setLoginStatus("loggein");
		login.setLoginTime(now);

		
		login = repo.save(login);
		
		return login;
		
	}

	@Override
	public boolean deleteLoginUserById(long id) {
		
		repo.deleteById(id);
		
		return true;
	}

	@Override
	public Login addLoginAdmin(AdminDTO admin) {
        Login login = new Login();
		
		String now = LocalDate.now() + "";
		Random random = new Random();   
		
		long randomNum = Math.abs( random.nextLong());
		
		login.setUid(randomNum);
		login.setUname(admin.getName());
		login.setLoginStatus("loggein");
		login.setLoginTime(now);

		
		login = repo.save(login);
		
		return login;
	}

}
