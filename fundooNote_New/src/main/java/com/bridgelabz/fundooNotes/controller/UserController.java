package com.bridgelabz.fundooNotes.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.bridgelabz.fundoo.exception.Exception;
import com.bridgelabz.fundooNotes.dto.UserDto;
import com.bridgelabz.fundooNotes.dto.LoginDto;
import com.bridgelabz.fundooNotes.response.Response;
import com.bridgelabz.fundooNotes.response.ResponseToken;
import com.bridgelabz.fundooNotes.service.UserService;

@RestController
@RequestMapping("/user_controller")
public class UserController {
	
	@Autowired
	UserService UserService;

	@PostMapping("/REGISTER")
	public ResponseEntity<Response> registrationOfUser(@RequestBody UserDto userDto)
			throws Exception, UnsupportedEncodingException {

		Response response = UserService.registrationOfUser(userDto);
		//System.out .println(response);
		System.out .print(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@PostMapping("/LOGIN")
	public ResponseEntity<ResponseToken> userLogin(@RequestBody LoginDto loginDto)
			throws Exception, UnsupportedEncodingException
	{
		ResponseToken response = UserService.userLogin(loginDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{token}/valid")
	public ResponseEntity<Response> emailValidation(@PathVariable String token) throws Exception {

		Response response = UserService.validateEmailId(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/FORGOTPASSWORD")
	public ResponseEntity<Response> forgotPassword(@RequestParam String emailId)
			throws UnsupportedEncodingException, Exception, MessagingException {
		System.out.println(emailId);
		Response status = UserService.forgetPassword(emailId);

		return new ResponseEntity<Response>(status, HttpStatus.OK);

	}

	@PutMapping(value = "/RESETPASSWORd/{token}")
	public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestParam("password") String password)
			throws Exception {
		Response response = UserService.passwordReset(token, password);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
}
