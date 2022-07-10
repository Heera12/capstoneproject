package com.wipro.capstoneproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstoneproject.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

	public List<Admin> findAdminByName(String name);

}
