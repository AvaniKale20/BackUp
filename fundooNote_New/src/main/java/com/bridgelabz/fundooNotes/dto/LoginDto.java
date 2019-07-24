package com.bridgelabz.fundooNotes.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/*******************
 *@class loginDto
 *@purpose login 
 *
 */
public class LoginDto {


	@Column(name = "emailId", nullable = false)
		@Email(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com|org))+$")
		@NotEmpty(message = "Please provide valid email")
		private String emailId;

		@NotEmpty(message = "Please provide password")
		@Column(name = "password")
		private String password;

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

		@Override
		public String toString() {
			return "loginDto [EmailId=" + emailId + ", Password=" + password + "]";
		}
		
		
}
