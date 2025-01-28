package com.spotico.DTO;

import java.sql.Date;

import com.spotico.pojos.Roles;

public class Usersdto {

		
		private String FName;
		
		private String LName;
		
		private String Email;
		
		private String Password;
		
		private Date DOB;
		
		private Roles Role;

		
		public Usersdto() {
		
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


		public Date getDOB() {
			return DOB;
		}


		public void setDOB(Date dOB) {
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
			return "Usersdto [FName=" + FName + ", LName=" + LName + ", Email=" + Email + ", Password=" + Password
					+ ", DOB=" + DOB + ", Role=" + Role + "]";
		}
		
		
	
		
}
