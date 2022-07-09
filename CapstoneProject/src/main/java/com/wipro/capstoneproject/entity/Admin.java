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
@Entity
@Data
@Table(name = "ADMIN_TABLE")
public class Admin {

	@Id
	private long id;
	@Column(name = "Admin_Name")
	private String name;
	@Column(name = "Admin_Email")
	private String email;
	@Column(name = "Admin_Password")
	private String password;

}
