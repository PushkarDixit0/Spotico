package com.sportico.DTO;

import java.time.LocalDate;

import com.sportico.pojos.Roles;

public class GetUserdto {

		
		private String FName;
		
		private String LName;
		
		private String Email;
				
		private LocalDate DOB;
		
		private Roles Role;

		
		public GetUserdto() {
		
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



	


		public Roles getRole() {
			return Role;
		}


		public void setRole(Roles role) {
			Role = role;
		}


		@Override
		public String toString() {
			return "Usersdto [FName=" + FName + ", LName=" + LName + ", Email=" + Email
					+ ", DOB=" + DOB + ", Role=" + Role + "]";
			
		}
		
		
	
		
}
