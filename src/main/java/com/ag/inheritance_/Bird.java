package com.ag.inheritance_;

import lombok.Builder;

public class Bird extends Animal{
	int wingSize;
	boolean canFly;

	@Builder
	public Bird(String name, String location, int wingSize, boolean canFly) {
		super(name, location);
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
