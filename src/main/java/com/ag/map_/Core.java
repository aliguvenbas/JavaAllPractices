package com.ag.map_;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Core {

	private Stream<String> stream;

	@BeforeEach
	public void setup() {
		stream = Stream.of("Ankara", "Adana", "Izmir", "Canakkale", "Corum", "Tekirdag");
	}

	@Test
	public void shouldThrowExceptionWhenTryToCreateMapWithSameKey() {
		assertThrows(IllegalStateException.class, () -> stream.collect(Collectors.toMap(
				city -> city.toCharArray()[0],
				city -> city
		)));
	}

	@Test
	public void shouldCombineValuesWithSameKey() {
		HashMap<Character, String> newMap = stream.collect(Collectors.toMap(
				city -> city.charAt(0),
				city -> city,
				(city1, city2) -> city1 + "-" + city2,
				HashMap::new
		));

		System.out.println("newMap:" + newMap);

		assertEquals(4, newMap.size());
	}
}
