package com.ag.java8lambdabasics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllMatch_ {

	@Test
	public void shouldTrueIfListEmpty() {
		List<Integer> list = new ArrayList<Integer>();
		boolean answer = list.stream().allMatch(number -> number > 0);

		assertTrue(answer);
	}

	@Test
	public void shouldFalseIfAtLeastOneItemNotInCondition() {
		List<Integer> list = Arrays.asList(1,2,-5,4);
		boolean answer = list.stream().allMatch(number -> number > 0);

		assertFalse(answer);
	}

	@Test
	public void shouldTrueIfAllItemsInCondition() {
		List<Integer> list = Arrays.asList(1,2,5,4);
		boolean answer = list.stream().allMatch(number -> number > 0);

		assertTrue(answer);
	}
}
