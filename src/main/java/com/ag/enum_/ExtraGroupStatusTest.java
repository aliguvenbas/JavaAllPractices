package com.ag.enum_;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtraGroupStatusTest {


	@Test
	public void shouldReturnNameOfEnumParameter() {
		assertEquals("SYNCED", ExtraGroupStatus.SYNCED.name());
	}

	@Test
	public void shouldReturnNameOfEnumParameterWhenParameterHasValue(){
		assertEquals("NOT_SYNCED",ExtraGroupStatusWithValue.NOT_SYNCED.name());
	}


	@Test
	public void shouldReturnValueOfEnumParameterWhenParameterHasValue(){
		assertEquals("NOT_SYNCED...",ExtraGroupStatusWithValue.NOT_SYNCED.getValue());
	}
}
