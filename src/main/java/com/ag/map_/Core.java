package com.ag.map_;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Core {

	private Stream<String> stream;
	private Map<String, String> map;

	@BeforeEach
	public void setup() {
		stream = Stream.of("Ankara", "Adana", "Izmir", "Canakkale", "Corum", "Tekirdag");
		map = new HashMap<>();
		map.put("a", "ankara");
		map.put("i", "izmir");
		map.put("c", "canakkale");
	}

	@Test
	public void shouldThrowExceptionWhenTryToCreateMapWithSameKey() {
		assertThrows(IllegalStateException.class, () -> stream.collect(Collectors.toMap(
				city -> city.toCharArray()[0],
				city -> city
		)));
	}

	@Test
	public void shouldNotMapValuesWithSameKey() {
		List<Item> items = Arrays.asList(new Item("1", "item-1"),
				new Item("1", "item-1"),
				new Item("2", "item-2"),
				new Item("3", "item-3"));

		assertThrows(IllegalStateException.class, ()->items.stream().collect(Collectors.toMap(Item::getId, item -> item)));
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

	@Test
	public void whatReturnWithEmptyMap() {
		map = new HashMap<>();

		boolean b = map.entrySet().stream()
				.filter(entry -> entry.getKey().contains("a"))
				.anyMatch(entry -> entry.getValue().contains("kara"));

		assertFalse(b);
	}
}

class Item {
	String id;
	String name;

	public Item(String id, String name) {
		this.id = id;
		this.name = name;
	}


	public String getId() {
		return id;
	}
}
