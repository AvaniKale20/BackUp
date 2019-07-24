package com.bridgelabz.fundooNotes.exception;

public class UserException extends RuntimeException{


	int code;
	String msg;
	 public UserException(String msg)
	 {
		super(msg);
	 }
	 
	 public UserException(int code, String msg)
	 {
		 super(msg);
		 this.code =code;
	 }
}
