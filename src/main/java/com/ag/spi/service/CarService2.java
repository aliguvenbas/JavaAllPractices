package com.ag.spi.service;

public class CarService2 extends CarService {
	@Override
	public String getPrice() {
		return "1250";
	}

	@Override
	public String calculateDistance() {
		return "5";
	}

	@Override
	public String name() {
		return "Maslak";
	}
}
