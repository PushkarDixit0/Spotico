package com.sportico.DTO;

import java.time.LocalDate;

import com.sportico.pojos.Roles;

public class PostUserdto {

		
		private String FName;
		
		private String LName;
		
		private String Email;
		
		private String Password;
				
		private LocalDate DOB;
		
		private Roles Role;

		
		public PostUserdto() {
		
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


		public LocalDate getDOB() {
			return DOB;
		}


		public void setDOB(LocalDate dOB) {
			DOB = dOB;
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


		public Roles getRole() {
			return Role;
		}


		public void setRole(Roles role) {
			Role = role;
		}


		@Override
		public String toString() {
			return "PostUserdto [FName=" + FName + ", LName=" + LName + ", Email=" + Email + ", Password=" + Password
					+ ", DOB=" + DOB + ", Role=" + Role + "]";
		}


	
		
	
		
}
