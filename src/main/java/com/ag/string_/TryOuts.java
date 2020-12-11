package com.ag.string_;

import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class TryOuts {

	//Equals
	@Test
	public void shouldCheckEqualityIfFirstParameterNotNull() {
		String str1 = "test";
		String str2 = null;

		assertFalse(str1.equals(str2));
	}

	@Test(expected = NullPointerException.class)
	public void shouldCheckEqualityIfFirstParameterNull() {
		String str1 = "test";
		String str2 = null;

		assertFalse(str2.equals(str1));
	}
}
