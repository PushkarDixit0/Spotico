package com.sportico.DTO;

import java.time.LocalDate;

public class PostUserdto extends Basedto{

		
		private String fName;
		
		private String lName;
		
		private String email;
		
		private String password;
		
		private String phoneNo;
				
		private LocalDate dob;
		
		
	


		public PostUserdto() {
			super();
			// TODO Auto-generated constructor stub
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

		

		public String getPhoneNo() {
			return phoneNo;
		}


		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}


		public void setPassword(String password) {
			this.password = password;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		public String getFName() {
			return fName;
		}


		public void setFName(String fName) {
			this.fName = fName;
		}

		public String getLName() {
			return lName;
		}


		public void setLName(String lName) {
			this.lName = lName;
		}



		@Override
		public String toString() {
			return "PostUserdto [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password
					+ ", phoneNo=" + phoneNo + ", dob=" + dob + "]";
		}

		
	


		
		
		
		
}