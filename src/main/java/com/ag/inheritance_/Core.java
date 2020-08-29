package com.ag.inheritance_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Core {
	public static void main(String[] args) {

		//case 1 basic : subtypes can be added to parent type list.
		List<Animal> animals = new ArrayList<>();
		animals.add(Cat.builder().type("Iran").pet(false).name("Cat").location("all world").build());
		animals.add(Fish.builder().type("Istavrit").name("fish").location("sea").build());
		animals.stream().forEach(System.out::println);


		//case 2 : parentCalss can not be added to sub type list.
		List<Cat> cats = new ArrayList<>();
		cats.add(Cat.builder().type("Iran").pet(false).build());
//		cats.add(Animal.builder().name("mammal").location("all world").build());
//		cats.add(Fish.builder().type("Istavrit").name("fish").location("sea").build());

		//Case 3:sub type can be assigned to parent class, vice versa not possible
		Animal animal = Cat.builder().type("Iran").pet(false).name("Cat").location("all world").build();
//		Cat cat = Animal.builder().name("mammal").location("all world").build();

		//Case 4:sub type can be casted to parent class
		List<Animal> animals2 = new ArrayList<>();
		animals2.add((Animal) Cat.builder().type("Iran").pet(false).name("Cat").location("all world").build());
		animals2.add((Animal) Fish.builder().type("Istavrit").name("fish").location("sea").build());
		animals2.stream().forEach(System.out::println);

		//Case 4:parent type can be casted to subtype at compile time, but not work at runtime
		List<Cat> cats2 = new ArrayList<>();
		cats2.add(Cat.builder().type("Iran").pet(false).build());
		cats2.add((Cat) new Animal("mammal", "all world"));
	}
}
