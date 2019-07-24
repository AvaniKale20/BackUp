package com.bridgelabz.fundoo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.bridgelabz.fundoo.dto.LoginDTo;
import com.bridgelabz.fundoo.dto.UserDTO;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.repository.UserRepository;
import com.bridgelabz.fundoo.response.ResponseToken;
import com.bridgelabz.fundoo.utility.TokenUtil;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	
private static final int Optional = 0;

private static final Object User = null;

@Mock
private UserServiceImpl userServiceImpl;

@Mock
private  PasswordEncoder passwordEncoder;

@Mock
private ModelMapper modelMapper;

@Mock
private UserRepository userRepo;

@Mock
private TokenUtil tokenUtil;

	@Test
	public void resistrationTest() {
		UserDTO userDto=new UserDTO("avani","kale","avanikale2@gmail.com","admin","1234567890");
		User user=new User("12","avani","kale","avanikale2@gmail.com","admin","12345");
		//when(userDto.getEmailId(Mockito.anyString())).thenReturn("avanikale2@gmail.com");
	//when(userDto.getEmailId()).thenReturn("avanikale2@gmail.com");
		//when(userDto.getEmailId()).thenReturn(userDto.getEmailId());
//		
//		Mockito.<Optional<User>>when(userRepo.findByEmailId("ava")).thenReturn
//      (Optional.of());
		Optional<User> useralreadyPresent=null;
		Mockito.<Optional<User>>when(userRepo.findByEmailId("")).thenReturn(useralreadyPresent);
		when(modelMapper.map(userDto, User.class)).thenReturn(user);
		when(passwordEncoder.encode(userDto.getPassword())).thenReturn(user.getPassword());
		when(userRepo.save(user)).thenReturn(user);
		assertEquals("avani",user.getFirstName());
		assertEquals(user, userRepo.save(user));

}
	@Test
	public void loginTest()
	{
		
		LoginDTo loginDto=new LoginDTo("avanikale2@gmail.com","admin");
		//User user=new User();
		//ResponseToken response = new ResponseToken();
	
		
		//when(tokenUtil.createToken(Mockito.anyLong())).thenReturn("gk");
		
		
		
	}
}