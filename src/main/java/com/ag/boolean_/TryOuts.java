package com.ag.boolean_;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TryOuts {

	@Test
	public void shouldReturnFalseIfTextNonSense() {
		String text = "test";

		Boolean aBoolean = Boolean.valueOf(text);

		assertFalse(aBoolean);
	}

	@Test
	public void shouldReturnThrowExceptionIfBoxedBooleanNull() {
		Boolean b = null;

		assertThrows(NullPointerException.class, () -> {
			if(b) {

			}
		});

	}
}
