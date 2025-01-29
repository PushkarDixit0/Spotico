package com.sportico.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User extends BasicEntity {
	
	@Column(name = "fname")
	private String FName;
	@Column(name = "lname")
	private String LName;
	@Column(name = "email")
	private String Email;
	@Column(name = "password")
	private String Password;
	@Column(name = "dob")
	private LocalDate DOB;
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Roles Role;

	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public Roles getRole() {
		return Role;
	}
	public void setRole(Roles role) {
		Role = role;
	}
	

	@Override
	public String toString() {
		return "Users [FName=" + FName + ", LName=" + LName + ", Email=" + Email + ", Password=" + Password + ", DOB="
				+ DOB + ", Role=" + Role + "]";
	}
	
}
