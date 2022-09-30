package com.bridgelabz.fundoo.dto;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class LoginDTo {

	@Column(name = "email", nullable = false)
		@Email(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com|org))+$")
		@NotEmpty(message = "Please provide valid email")
		private String emailId;

		@NotEmpty(message = "Please provide password")
		@Column(name = "password")
		private String password;

		public LoginDTo(
				@Email(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com|org))+$") @NotEmpty(message = "Please provide valid email") String emailId,
				@NotEmpty(message = "Please provide password") String password) {
			super();
			this.emailId = emailId;
			this.password = password;
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

		@Override
		public String toString() {
			return "LoginDTO [emailId=" + emailId + ", password=" + password + "]";
		}

	}

