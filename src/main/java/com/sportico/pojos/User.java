
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
	private String fName;
	@Column(name = "lname")
	private String lName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	@Column(name = "phoneNo")
	private String phoneNo;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Roles role;

	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public String getfName() {
		return fName;
	}






	public void setfName(String fName) {
		this.fName = fName;
	}






	public String getlName() {
		return lName;
	}






	public void setlName(String lName) {
		this.lName = lName;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getPhoneNo() {
		return phoneNo;
	}






	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}






	public LocalDate getDob() {
		return dob;
	}






	public void setDob(LocalDate dob) {
		this.dob = dob;
	}






	public Roles getRole() {
		return role;
	}






	public void setRole(Roles role) {
		this.role = role;
	}






	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", dob=" + dob + ", role=" + role + "]";
	}



	

	
	
	
}
