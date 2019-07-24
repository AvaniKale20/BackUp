package com.bridgelabz.fundoo.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bridgelabz.fundoo.dto.LoginDTo;
import com.bridgelabz.fundoo.dto.UserDTO;
import com.bridgelabz.fundoo.exception.UserException;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.response.ResponseToken;
//import com.bridgelabz.fundoo.dto.LoginDTo;
//import com.bridgelabz.fundoo.dto.UserDTo;
//import com.bridgelabz.fundoo.model.User;

@Service
public interface UserService {

	Response registrationUser(UserDTO userDto) throws UserException, UnsupportedEncodingException;

	ResponseToken loginForUser(LoginDTo loginDto) throws UserException, UnsupportedEncodingException;

	ResponseToken authenticationUser(Optional<User> user, String password);

	Response validationOfEmailId(String token);

	Response passwordReset(String token, String password);

	Response userforgetPassword(String emailId) throws UserException, UnsupportedEncodingException;
}
