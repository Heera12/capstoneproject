package com.wipro.capstoneproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// service class for admin
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.entity.Admin;
import com.wipro.capstoneproject.repository.IAdminRepository;

@Service
public class AdminServiceImp implements IAdminService{
	
	@Autowired
	IAdminRepository repo;
	
	
	@Override
	public Admin addAdmin(Admin admin) {
		
		return repo.save(admin);
	}
	
	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public Admin getAdminById(long aid) {
		// TODO Auto-generated method stub
		return repo.findById(aid).orElse(new Admin());
	}


	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return repo.save(admin);
	}


	@Override
	public List<Admin> getAdminByName(String name) {
		// TODO Auto-generated method stub
		return repo.findAdminByName(name);
	}


	@Override
	public ResponseEntity<String> deleteAdminById(long aid) {
		// TODO Auto-generated method stub
		 repo.deleteById(aid);
		 return new ResponseEntity<String>("Record Deleted Sucessfully", HttpStatus.ACCEPTED);
	}
	
	public static boolean validateUser(Admin admin) {

		boolean flag = false;

		if (admin.getName().length()>4 && admin.getEmail().length()>4 && admin.getPassword().length()>4) {

			flag = true;
		}

		return flag;

	}

}
