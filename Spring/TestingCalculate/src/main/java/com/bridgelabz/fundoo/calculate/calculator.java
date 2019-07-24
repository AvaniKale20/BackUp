package com.bridgelabz.fundoo.calculate;

import com.bridgelabz.fundoo.service.calculatorService;

public class calculator {
	
	calculatorService service;
	
	
	public calculator(calculatorService service) {
		super();
		this.service = service;
	}


	public int perform(int i,int j)
	{
		return service.add(i,j)*i;
	}

}
