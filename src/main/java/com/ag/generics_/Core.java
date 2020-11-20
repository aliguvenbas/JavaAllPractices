package com.ag.generics_;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Core {

	@Test()
	public void unboundedWildCartTypes() {
//		Set<?> set = new HashSet<Fish>();
//		set.add(new Fish.FishBuilder().type("kartal")); Compile error

		/*
		## you can assign a parameterized set object with type to Set<?>
		You can't use like normal set collection like above and below.
		Even after assigned a parameterized set added s.30
		It gives you type safety only.
		*/

		Set<Fish> fishSet = new HashSet<>();
		fishSet.add(new Fish.FishBuilder().type("kartal").build());

		Set<?> set = fishSet;
//		set.add(new Fish.FishBuilder().type("kartal").build());
		assertTrue(set.iterator().next() instanceof Fish);

		Set nonParameterizedSet = new HashSet();
		nonParameterizedSet.add(new Bird.BirdBuilder().wingSize(30).build());
		nonParameterizedSet.add(new Snake.SnakeBuilder().maxLength(4).build());
		set = nonParameterizedSet;

		System.out.println("nonParameterizedSet:" + set);

//		List<?> listOfAnyType;
//		List<Object> listOfObject = new ArrayList<Object>();
//		List<String> listOfString = new ArrayList<String>();
//		List<Integer> listOfInteger = new ArrayList<Integer>();
//
//		listOfAnyType = listOfString; //legal
//		listOfAnyType = listOfInteger; //legal
//		listOfObjectType = (List<Object>) listOfString; //compiler error - in-convertible types
	}

	@Test()
	public void shouldAddDifferentObjectToSameRawList() {
		List list = new ArrayList();
		list.add(new Bird.BirdBuilder().wingSize(30).build());
		list.add(new Snake.SnakeBuilder().maxLength(4).build());

		System.out.println(list);
	}

	@Test()
	public void shouldAddDifferentObjectToGenericListNotGivesErrorButNotRecommended() {
		List<Fish> list = new ArrayList<>();
		unsafeAdd(list, new Bird.BirdBuilder().wingSize(30).build());
		unsafeAdd(list, new Snake.SnakeBuilder().maxLength(4).build());

		System.out.println(list);
	}

	@Test
	public void shouldAddDifferentObjectToGenericListNotGivesErrorButThrowExceptionWhenGetInWrongType() {
		List<Fish> list = new ArrayList<>();
		unsafeAdd(list, new Bird.BirdBuilder().wingSize(30).build());
		unsafeAdd(list, new Snake.SnakeBuilder().maxLength(4).build());

		assertThrows(ClassCastException.class, () -> {
			Fish fish = list.get(1);
		});
	}

	private void unsafeAdd(List list, Object o) {
		list.add(o);
	}
}
