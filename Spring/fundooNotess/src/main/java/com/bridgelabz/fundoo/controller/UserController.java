package com.bridgelabz.fundoo.controller;

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
import com.bridgelabz.fundoo.exception.UserException;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.response.ResponseToken;
import com.bridgelabz.fundoo.service.UserService;
import com.bridgelabz.fundoo.dto.LoginDTo;
import com.bridgelabz.fundoo.dto.UserDTO;

@RestController
//return the object data written into http response as json format
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody UserDTO userDto)
			throws UserException, UnsupportedEncodingException {

		Response response = userService.registrationUser(userDto);
		System.out .println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<ResponseToken> LoginUser(@RequestBody LoginDTo loginDTO)
			throws UserException, UnsupportedEncodingException {

		ResponseToken response = userService.loginForUser(loginDTO);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{token}/valid")
	public ResponseEntity<Response> emailValidation(@PathVariable String token) throws UserException {

		Response response = userService.validationOfEmailId(token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/forgotpassword")
	public ResponseEntity<Response> forgotPassword(@RequestParam String emailId)
			throws UnsupportedEncodingException, UserException, MessagingException {
		System.out.println(emailId);
		Response status = userService.userforgetPassword(emailId);

		return new ResponseEntity<Response>(status, HttpStatus.OK);

	}

	@PutMapping(value = "/resetpassword/{token}")
	public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestParam("password") String password)
			throws UserException {
		Response response = userService.passwordReset(token, password);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
}
