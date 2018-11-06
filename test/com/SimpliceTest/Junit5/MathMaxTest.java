package com.SimpliceTest.Junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathMaxTest {

	@Test
	void test() {
		int actualResult = Math.max(10, 20);
		int expectedResult = 20;
		
		//write our assertion
		assertEquals(expectedResult,actualResult);
		
	}

}
