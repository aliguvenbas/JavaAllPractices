package com.ag.generics_;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Core {


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
	public void shouldAddDifferentObjectToGenericListNotGivesErrorButThrowExceptionWhenGetInWrongType(){
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
