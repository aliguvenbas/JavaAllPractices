package com.ag.inheritance_;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;

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
