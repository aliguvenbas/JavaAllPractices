package com.ag.interview_;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ch1_5Test {

	ch1_5 q = new ch1_5();
	
	@Test
	void test() {
		String expected = q.replaceSpaces("veni vidi vici");
		System.out.println(expected);

		assertEquals("veni%20vidi%20vici", expected);
	}
	
	@Test
	void test2() {
		assertNull(q.replaceSpaces(null));
	}
	
	@Test
	void test3() {
		assertEquals("merhaba", q.replaceSpaces("merhaba"));
	}

}
