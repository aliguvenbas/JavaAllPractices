package com.ag.boolean_;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TryOuts {

	@Test
	public void shouldReturnFalseIfTextNonSense(){
		String text = "test";

		Boolean aBoolean = Boolean.valueOf(text);

		assertFalse(aBoolean);
	}
}
