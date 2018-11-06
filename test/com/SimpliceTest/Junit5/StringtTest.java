package com.SimpliceTest.Junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringtTest {

	@Test
	void testSringLenght() {
		int actualLenght = "ABCD".length();
		int expectedLenght = 4;
		
		//write our asserstion
		assertEquals(expectedLenght, actualLenght);
		
		
		actualLenght = "".length();
		expectedLenght = 0;
		
		//write our asserstion
		assertEquals(expectedLenght, actualLenght);
		
		
		//invoke the method square(4) => CUT
		
		//checks in place - 16 => assertion => check the value or result  that are coming out of the method we are testing 
	}
	
	@Test
	void testStringUpperCase()
	{
		String str = "abcd";
		String actualRestult = str.toUpperCase();
		String expectedRestult = "ABCD";
		
		//write out assertion
		assertEquals(expectedRestult,actualRestult);
		
		 //String str1 = null;
		String str1 = "abc";
		//write our assertion not null
		 assertNotNull(str1);
		
	}
	
	@Test
	void testStringContains()
	{
		String str = "abcdefg";
		boolean expectedResult = str.contains("abc");
		
		//write our asserstion
		assertEquals(true,expectedResult);
		
	}
	
	@Test
	void testStringSplit()
	{
		String str = "abc def ghi";
		String [] actualResult = str.split(" ");
		String [] expectedResult = new String [] {"abc","def","ghi"};
		
		assertArrayEquals(expectedResult,actualResult);
	}

}
