package com.SimpliceTest.Junit5;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringtTest {
	
	
	@BeforeAll //run before all test method
	static void beforeAll() 
	{
		System.out.println("Initialize DB connection  ");
	}
	
	@AfterAll //run after all test method
	static void afterAll()
	{
		System.out.println("closing DB connection  ");
	}
	
	@BeforeEach //run before each test method
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for : "+info.getDisplayName());
	}
	
	@AfterEach//run after each test method
	void afterEach(TestInfo info)
	{
		System.out.println("clean up data Test Data for:  "+info.getDisplayName());
	}

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
	
	@Test
	@DisplayName("when length is null throws and exception")
	void testSringLenght_exception() {
		String str = null;
		
		//write our asserstion
		assertThrows(NullPointerException.class,
				    ()->{
				    	str.length();
				    }
				);	
	}
	
	@Test
	void length_greater_than_zero()
	{
		assertTrue("ABCD".length()>0);
		assertTrue("ABC".length()>0);
		assertTrue("ABCDEDF".length()>0);
		assertTrue("A".length()>0);
	}

	
	@ParameterizedTest 
	@ValueSource(strings = {"ABCD","QC","EDCO","DED","EDRF"})
	void length_greater_than_zero_using_parametized(String str)
	{
		assertTrue(str.length()>0);
	}

	@ParameterizedTest (name = "{0} Capitalized is {1}")
	@CsvSource(value = {"abcd,ABCD","ab, AB","'',''","ac,AC"})
	void uppserCase(String word, String capitalizedWord)
	{
		assertEquals(capitalizedWord,word.toUpperCase());
	}
	
	@Test
	void performanceTest()
	{
		assertTimeout(Duration.ofSeconds(5),
				()->{
					for (int i =0; i<=1000;i++)
					{
						System.out.println(i);
					}
				}
				);
	}
}
