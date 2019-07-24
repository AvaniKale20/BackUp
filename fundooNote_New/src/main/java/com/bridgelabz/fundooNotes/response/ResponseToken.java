package com.bridgelabz.fundooNotes.response;

public class ResponseToken {

	private String StatusMsg;
	private int statusCode;
	private String token;
	public String getStatusMsg() {
		return StatusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		StatusMsg = statusMsg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "ResponseToken [StatusMsg=" + StatusMsg + ", statusCode=" + statusCode + ", token=" + token + "]";
	}
	
	
}
