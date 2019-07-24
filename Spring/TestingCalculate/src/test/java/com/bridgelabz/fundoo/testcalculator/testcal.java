package com.bridgelabz.fundoo.testcalculator;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.bridgelabz.fundoo.calculate.calculator;
import com.bridgelabz.fundoo.service.calculatorService;

public class testcal {
	calculator c=null;
	@Mock
	calculatorService service;
	@Rule
	public MockitoRule rule=MockitoJUnit.rule();
		
	
	@Before
	public void setUp()
	{
		c=new calculator(service);
	}
	@Test
	public void testperform() {
		when(service.add(2, 3)).thenReturn(5);
		assertEquals(10,c.perform(2, 3));
		//verify(service).add(2, 3);
	
	}

}
