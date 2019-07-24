package com.bridgelabz.fundoo.dto;

public class UserDTO {
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String mobileNum;
	
	
	
	public UserDTO(String firstName, String lastName, String emailId, String password, String mobileNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNum = mobileNum;
	}
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
//	@Override
//	public String toString() {
//		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password="
//				+ password + ", mobileNum=" + mobileNum + "]";
//	}
//	

}
