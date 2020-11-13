package com.ag.generics_;

import lombok.Builder;

public class Bird {
	int wingSize;
	boolean canFly;

	@Builder
	public Bird(int wingSize, boolean canFly) {
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
