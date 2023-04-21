package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	Welcome wel;
	
	@BeforeEach
	void setUp() throws Exception{
		wel = new Welcome();
	}
	
	
	@Test
	void test_EX1() {
		assertEquals("Hello, Bob",wel.welcome("bob"));
	}
	
	@Test
	void test_EX2() {
		assertEquals("Hello, my friend", wel.welcome(""));
		assertEquals("Hello, my friend", wel.welcome("       "));

	}
	

}
