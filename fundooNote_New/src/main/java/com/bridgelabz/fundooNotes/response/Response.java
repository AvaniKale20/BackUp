package com.bridgelabz.fundooNotes.response;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	private String StatusMsg;
	private int statusCode;
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
	@Override
	public String toString() {
		return "Response [StatusMsg=" + StatusMsg + ", statusCode=" + statusCode + "]";
	}
	

}
