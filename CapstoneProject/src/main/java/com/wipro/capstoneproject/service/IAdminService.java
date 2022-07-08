package com.wipro.capstoneproject.service;
import java.util.List;

import org.springframework.http.ResponseEntity;
// service interface for admin
import org.springframework.stereotype.Service;

import com.wipro.capstoneproject.entity.Admin;


@Service
public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	
	public List<Admin> getAllAdmin();
	
	public Admin getAdminById(long aid);
	
	public Admin updateAdmin(Admin admin);
	
	public List<Admin> getAdminByName(String name);
	
	public ResponseEntity<String> deleteAdminById(long aid);

}
