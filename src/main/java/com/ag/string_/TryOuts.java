package com.ag.string_;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void shouldRepresentConditionValueAsString() {
		boolean cond1 = true;
		Boolean cond2 = false;
		boolean cond3 = false;

		String condValue = String.valueOf(cond1 && cond2 && cond3);

		assertSame("false", condValue);
		assertTrue(condValue instanceof String);
		assertTrue(condValue.equals("false"));
	}
}
