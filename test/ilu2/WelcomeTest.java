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
		assertEquals("Hello, my friend", wel.welcome(null));
	}
	
	@Test
	void test_EX3(){
		assertEquals("HELLO, JERRY !", wel.welcome("JERRY"));
		assertEquals("HELLO, CARL !", wel.welcome("CARL"));
		assertEquals("HELLO, PIERRE !", wel.welcome("PIERRE"));

	}
	
	@Test
	void test_EX4() {
		assertEquals("Hello, Amy and Bob", wel.welcome("amy,bob"));
		assertEquals("Hello, Jacques and Pierre", wel.welcome("jacques,pierre"));
	}
	
	@Test
	void test_EX5() {
		assertEquals("Hello, Amy, Bob and Jerry", wel.welcome("amy,bob,jerry"));
		assertEquals("Hello, Amy, Bob, Jerry and Pierre", wel.welcome("amy,bob,jerry,pierre"));
		assertEquals("Hello, Amy and Bob", wel.welcome("amy,bob"));
	}
	
	@Test
	void test_EX6() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !",wel.welcome("amy,BOB,jerry"));
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !",wel.welcome("BOB,amy,jerry"));
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !",wel.welcome("amy,jerry,BOB"));
	}

	@Test
	void test_EX7() {
		assertEquals("Hello, Bob, Amy and Jerry",wel.welcome("bob,amy,jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !",wel.welcome("bob,AMY,jerry,JACK"));
		assertEquals("Hello, Bob. AND HELLO, AMY AND JERRY !",wel.welcome("bob,AMY,JERRY"));
	}
	
	@Test
	void test_EX8() {
		assertEquals("Hello, Bob and Amy", wel.welcome("bob     ,amy   "));
		assertEquals("Hello, Bob and Amy", wel.welcome("     bob     ,   amy"));
	}
	
	@Test
	void test_EX9() {
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) !", wel.welcome("bob,JERRY,amy,bob,JERRY,bob"));
		assertEquals("Hello, Bob (x3), Amy and Pierre. AND HELLO, JERRY (x2) !", wel.welcome("bob,JERRY,amy,bob,JERRY,bob,pierre"));
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) AND PIERRE !", wel.welcome("bob,JERRY,amy,bob,JERRY,bob, PIERRE"));
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2), BOB (x2) AND NATHAN !", wel.welcome("bob,JERRY,amy,bob,JERRY,bob, BOB, BOB, NATHAN"));
	}
	@Test
	void test_Ex10() {
		assertEquals("Bob, Yoda and Amy, Hello. AND HELLO, JERRY !",wel.welcome("bob,yoda,amy,JERRY"));
		assertEquals("Hello, Bob and Amy. AND YODA (x2) AND JERRY, HELLO !",wel.welcome("bob,YODA,amy,JERRY,YODA"));
		assertEquals("Bob, Amy and Yoda, Hello. AND YODA (x2) AND JERRY, HELLO !",wel.welcome("bob,YODA,amy,JERRY,YODA,yoda"));

	}
	
}
