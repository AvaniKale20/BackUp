package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.example.demo.TestDemo.Math;

public class MathTest {

	private Math math;
	
@BeforeMethod
public void setUp()
{
	math=new Math();
	System.out.println("set up method called");
}

@Test
public void add()
{
	System.out.println("add method callled");
	int excepted=4;
	int actual=math.add(2, 2);
	Assert.assertEquals(actual,excepted);
}
@Test
public  void divide()
{
	System.out.println("divide method called");
	int excepted=2;
	int actual=math.add(6, 3);
	Assert.assertEquals(actual,excepted);
}

//@Test
public void multiply()
{System.out.println("multiply method called");
	int excepted=10;
	int actual=math.add(2, 5);
	Assert.assertEquals(actual,excepted);	
}

@AfterMethod
public void tearDown()
{System.out.println("tear down method called");
	math=null;
}
}
