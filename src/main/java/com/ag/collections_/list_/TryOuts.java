package com.ag.collections_.list_;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TryOuts {

	@Test
	public void whenWeAddNewElementToArrayListTheHashCodeShouldBeChanged(){
		List<String> list  = new ArrayList<>();
		list.add("test-1");
		list.add("test-2");

		int hashCodeB = list.hashCode();
		int hashCodeOfFirstElementB = list.get(0).hashCode();

		list.add("test-3");

		int hashCodeA = list.hashCode();
		int hashCodeOfFirstElementA = list.get(0).hashCode();

		System.out.println(hashCodeB);
		System.out.println(hashCodeOfFirstElementB);
		System.out.println(hashCodeA);
		System.out.println(hashCodeOfFirstElementA);


		/**
		 The hashCode() method of ArrayList is computed based on the contents of the list.
		 When you call hashCode() on an ArrayList, it calculates a hash code by combining
		 the hash codes of its elements. Since you added a new element ("test-3") to the
		 list between the two calls to hashCode(), the hash code of the ArrayList (hashCodeA)
		 is likely to be different from the hash code calculated before adding the element (hashCodeB).
		**/
		assertNotSame(hashCodeA, hashCodeB);
		assertEquals(hashCodeOfFirstElementA, hashCodeOfFirstElementB);
	}
}
