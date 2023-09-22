package com.ag.string_;


import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TryOuts {

	//Equals
	@Test
	public void shouldCheckEqualityIfFirstParameterNotNull() {
		String str1 = "test";
		String str2 = null;

		assertFalse(str1.equals(str2));
	}

	@Test
	public void shouldCheckEqualityIfFirstParameterNull() {
		String str1 = "test";
		String str2 = null;

		Assertions.assertThrows(NullPointerException.class, () -> {
			str2.equals(str1);
		});
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
