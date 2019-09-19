package com.ag.interview_;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ch1_8Test {

	ch1_8 test;

	@BeforeEach
	void init() {
		test = new ch1_8();
	}

	@Test
	@DisplayName("true cond")
	void test() {
		String str1 = "take";
		String str2 = "aket";
		assertTrue(test.isSubString(str1, str2));
	}
	
	
	
	@Test
	@DisplayName("wrong code")
	void test2(){
		assertFalse(test.isSubString("alik", "test"));
	}
	
	@Test
	@DisplayName("strings lengths are not equals")
	void test3(){
		assertFalse(test.isSubString("alik", "alikalik"));
	}
	
	@Test
	@DisplayName("strings lengths are not equals 2")
	void test4(){
		assertFalse(test.isSubString("alikalik", "alik"));
	}

}
