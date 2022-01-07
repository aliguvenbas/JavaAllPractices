package com.ag.spi;

import com.ag.spi.service.CarService;
import java.util.ServiceLoader;

public class CarServiceCalculatorApp {

	public static void main(String[] args) {
		ServiceLoader<CarService> carServiceLoader = ServiceLoader.load(CarService.class);

		System.out.println("started...");

		try {
			Class.forName("com.ag.spi.service.CarService");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Class.forName("com.ag.spi.service.CarService1");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		for(CarService carService : carServiceLoader) {
			System.out.println(
					"Name:" + carService.name() + " price:" + carService.getPrice() + " distance:" + carService.calculateDistance());
		}
	}
}
