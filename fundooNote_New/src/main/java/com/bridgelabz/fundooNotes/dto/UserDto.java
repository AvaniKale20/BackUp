package com.bridgelabz.fundooNotes.dto;

public class UserDto {

	
		private String firstName;
		private String lastName;
		private String emailId;
		private String password;
		private String mobileNum;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobileNum() {
			return mobileNum;
		}
		public void setMobileNum(String mobileNum) {
			this.mobileNum = mobileNum;
		}
		@Override
		public String toString() {
			return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password="
					+ password + ", mobileNum=" + mobileNum + "]";
		}

	}

	

