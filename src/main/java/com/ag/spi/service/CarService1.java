package com.ag.spi.service;

public class CarService1 extends CarService {
	@Override
	public String getPrice() {
		return "1200";
	}

	@Override
	public String calculateDistance() {
		return "35";
	}

	@Override
	public String name() {
		return "Maltepe";
	}
}
