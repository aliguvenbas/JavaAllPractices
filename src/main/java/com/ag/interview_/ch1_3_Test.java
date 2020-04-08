package com.ag.interview_;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ch1_3_Test {
	ch1_3 test;

	@BeforeEach
	void init() {
		test = new ch1_3();
	}

	@Test
	void test1() {
		assertEquals("merhab l  ",  test.removeDuplicetes("merhabalar"));
	}
	
	@Test
	void test2() {
		assertNull(test.removeDuplicetes(null));
	}
	
	@Test
	void test3() {
		String word="d";
		assertEquals(word, test.removeDuplicetes(word));
	}
	
	@Test
	void test4() {
		String word="dd";
		assertEquals("d ", test.removeDuplicetes(word));
	}

}
