package com.ag.generics_;

public class Animal {
	String name;
	String location;

	public Animal(String name, String location) {
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
