package com.ag.inheritance_;

import lombok.Builder;

public class Fish extends Animal {
	String type;

	@Builder
	public Fish(String name, String location, String type) {
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
