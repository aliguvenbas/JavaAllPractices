package com.ag.iterator_;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TryOuts {

	@Test
	public void shouldGetNextAndNotRemoveItFromTheIterator(){
		List<String> list = new ArrayList<>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");

		String next = list.iterator().next();

		assertEquals(4, list.size());
	}
}
