package com.bridgelabz.fundooNotes.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bridgelabz.fundooNotes.dto.LoginDto;
import com.bridgelabz.fundooNotes.dto.UserDto;
import com.bridgelabz.fundooNotes.model.User;
import com.bridgelabz.fundooNotes.response.Response;
import com.bridgelabz.fundooNotes.response.ResponseToken;
@Service
public interface UserService {
	Response registrationOfUser(UserDto userDto) throws Exception, UnsupportedEncodingException;
   
	ResponseToken userLogin(LoginDto loginDto) throws Exception, UnsupportedEncodingException;

	ResponseToken authentication(Optional<User> user, String password);
	 
	Response validateEmailId(String token);

	Response passwordReset(String token, String password);
	
	Response forgetPassword(String emailId) throws Exception, UnsupportedEncodingException;

}

