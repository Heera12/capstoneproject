package com.wipro.capstoneproject.repository;
// repository interface for admin
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstoneproject.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
