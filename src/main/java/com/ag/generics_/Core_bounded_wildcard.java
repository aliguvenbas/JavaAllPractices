package com.ag.generics_;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import org.junit.jupiter.api.Test;

public class Core_bounded_wildcard {

	@Test
	public void useBoundedWildcardAtClass() {
		AnimalList<Animal_bounded_wildcard> animalList = new AnimalList<>();

		animalList.addToList(new Fish_bounded_wildcard("shark", "ocean", "big fish"));
		animalList.addToList(new Cat_bounded_wildcard("tiger", "forest", "big cat", false));
//		animalList.addToList(new Bird_bounded_wildcard(4,true))//Provide type safety, object has to be subtype of Animal_bounded_wildcard

		assertTrue(animalList.getList().get(0) instanceof Fish_bounded_wildcard);
		assertTrue(animalList.getList().get(1) instanceof Cat_bounded_wildcard);
	}

	@Test
	public void useBoundedWildcardAtMethod(){

	}

}

class AnimalList<E extends Animal_bounded_wildcard> {

	List<E> list = new ArrayList<E>();

	public void addToList(E animal) {
		list.add(animal);
	}

	public List<E> getList() {
		return list;
	}

	public Number giveRandomSpeciesId(Object obj){
		return null;
	}
}

class Animal_bounded_wildcard {
	String name;
	String location;

	public Animal_bounded_wildcard(String name, String location) {
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}

class Fish_bounded_wildcard extends Animal_bounded_wildcard {
	String type;

	@Builder
	public Fish_bounded_wildcard(String name, String location, String type) {
		super(name, location);
		this.type = type;
	}

	@Override
	public String toString() {
		return "Fish{" +
				"type='" + type + '\'' +
				'}';
	}
}

class Cat_bounded_wildcard extends Animal_bounded_wildcard {
	String type;
	boolean pet;

	@Builder
	public Cat_bounded_wildcard(String name, String location, String type, boolean pet) {
		super(name, location);
		this.type = type;
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"type='" + type + '\'' +
				", pet=" + pet +
				'}';
	}
}


class Bird_bounded_wildcard {
	int wingSize;
	boolean canFly;

	@Builder
	public Bird_bounded_wildcard(int wingSize, boolean canFly) {
		this.wingSize = wingSize;
		this.canFly = canFly;
	}

	@Override
	public String toString() {
		return "Bird{" +
				"wingSize=" + wingSize +
				", canFly=" + canFly +
				'}';
	}
}
