package com.ag.inheritance_;

import lombok.Builder;

public class Cat extends Animal{
	String type;
	boolean pet;

	@Builder
	public Cat(String name, String location, String type, boolean pet) {
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
