package com.example.demo.TestDemo;

public class Math {

	public Math()
	{
		
	}
	public static int add(int a,int b)
	{
		return a+b;
	}
	public static int divide(int c,int d)
	{
		if(d==0)
			throw new IllegalArgumentException("can not divide by 0");
		return c/d;
	}
	public static int multiply(int x,int y)
	{
		return x*y;
		
	}
}
