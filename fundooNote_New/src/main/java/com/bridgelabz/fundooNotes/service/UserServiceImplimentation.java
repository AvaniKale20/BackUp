package com.bridgelabz.fundooNotes.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooNotes.dto.UserDto;
import com.bridgelabz.fundooNotes.dto.LoginDto;
import com.bridgelabz.fundooNotes.model.User;
import com.bridgelabz.fundooNotes.repository.UserRepository;
import com.bridgelabz.fundooNotes.response.Response;
import com.bridgelabz.fundooNotes.response.ResponseToken;
import com.bridgelabz.fundooNotes.utility.ResponseHelper;
import com.bridgelabz.fundooNotes.utility.Utility;
import com.bridgelabz.fundooNotes.utility.Token;
import com.bridgelabz.fundooNotes.exception.UserException;

@PropertySource("classpath:Msg.properties")
@Service("UserService")
public class UserServiceImplimentation implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private Token Token;

	@Autowired
	private Response statusResponse;

	@Autowired
	private Environment environment;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public Response registrationOfUser(UserDto userDto) throws UserException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String emailid = userDto.getEmailId();
		
		Optional<User> userPresent = userRepository.findByEmailId(emailid);
		
		if (userPresent.isPresent()) {
			throw new UserException(environment.getProperty("status.register.emailExistError"));
		}
		
		User user=modelMapper.map(userDto,User.class);
		
		String password = passwordEncoder.encode(userDto.getPassword());

		user.setPassword(password);
		user = userRepository.save(user);
		
		Long userId = user.getUserId();
		System.out.println(emailid + " " + userId);
		
		Utility.send(emailid, "confirmation mail", Utility.getUrl(userId) + "/valid");

		statusResponse = ResponseHelper.statusResponse(200, "register successfully");
		return statusResponse;

	}

	@Override
	public ResponseToken userLogin(LoginDto loginDto) throws UserException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		Optional<User> user = userRepository.findByEmailId(loginDto.getEmailId());
		ResponseToken response = new ResponseToken();
	
		if (user.isPresent()) {

			return authentication(user, loginDto.getPassword());

		}
		throw new UserException(401, environment.getProperty("user.register.error "));		

	//throw new Exception(401, environment.getProperty("user.forgetpassword.emaiId "));
	//	System.out.println("response is " + response);
//	return response;

	}


	@Override
	public ResponseToken authentication(Optional<User> user, String password) {
		// TODO Auto-generated method stub

		ResponseToken response = new ResponseToken();
		
		if (user.get().isVerify()) {
			boolean status = passwordEncoder.matches(password, user.get().getPassword());

			if (status) {
				String token = Token.createToken(user.get().getUserId());
			response.setToken(token);
			response.setStatusCode(200);
				response.setStatusMsg(environment.getProperty("user.login"));
				return response;
			}


			throw new UserException(401, environment.getProperty("user.login.password"));		
			}

		throw new UserException(401, environment.getProperty("user.login.verification"));
	}
	

	@Override
	public Response validateEmailId(String token) {
		// TODO Auto-generated method stub
		Long id = Token.decodeToken(token);
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserException(404, environment.getProperty("user.validation.email")));
		user.setVerify(true);
		
		userRepository.save(user);
		statusResponse = ResponseHelper.statusResponse(200, environment.getProperty("user.validation"));
		return statusResponse;
	}

	@Override
	public Response passwordReset(String token, String password) {
		// TODO Auto-generated method stub
		
		Long id = Token.decodeToken(token);
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserException(404, environment.getProperty("user.resetpassword.user")));
		String encodedpassword = passwordEncoder.encode(password);
		user.setPassword(encodedpassword);
		userRepository.save(user);
		return ResponseHelper.statusResponse(200, "password successfully reset");
	}

	@Override
	public Response forgetPassword(String emailId) throws UserException, UnsupportedEncodingException {

		Optional<User> userPresent = userRepository.findByEmailId(emailId);

		if (!userPresent.isPresent()) {

			throw new UserException(401, environment.getProperty("user.forgetpassword.emaiId"));
		}
		Long id = userPresent.get().getUserId();
		
		Utility.send(emailId, "password reset mail", Utility.getUrl(id));
		
		return ResponseHelper.statusResponse(200, environment.getProperty("user.forgetpassword.link"));
	}

}
