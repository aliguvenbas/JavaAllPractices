package com.ag.designpatterns.structural.flyweight;

import static junit.framework.Assert.assertEquals;

import java.util.EnumSet;
import java.util.List;
import org.junit.jupiter.api.Assertions

		;
import org.junit.jupiter.api.Test;

public class Core {


	@Test
	public void shouldNotAddSameObjectWithIdToMap(){
		Drum drum1 = InstrumentFactory.getDrum("drum1");
		Drum drum2 = InstrumentFactory.getDrum("drum1");

		assertEquals(1, InstrumentFactory.getObjectList().size());
	}
}
