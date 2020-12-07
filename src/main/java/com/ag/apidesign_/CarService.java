package com.ag.apidesign_;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	List<Car> carList = Arrays.asList(new Car.CarBuilder().id("some-id-1").team("mercedes").pilot("lewis hamilton").build(),
			new Car.CarBuilder().id("some-id-2").team("alpha tauri").pilot("pierre gasly").build());

	public Car create(Car car) {
		boolean valid = true;
		if(valid) {
			//creation process, basically give an id
			car.setId(UUID.randomUUID().toString());
			return car;
		} else {
			//specified validation exception
			throw new IllegalStateException("Not valid");
		}
	}

	public List<Car> getAll() {
		return carList;
	}

	public Car getById(String id) {
		return carList.stream()
				.filter(car -> car.id.equals(id))
				.findFirst()
				.orElse(null);
	}

	public Car update(Car car) {
		boolean forSomeReasonCouldNotBeUpdated = true;
		if(forSomeReasonCouldNotBeUpdated) {
			//update process
			return car;
		} else {
			throw new IllegalStateException("Could not be updated for some reason");//index conflict, etc
		}
	}

	public void deleteAll() {

	}

	public void deleteById(String id) {

	}

	public void startRace() {

	}

	public String getRaceStatus() {
		return "started";
	}
}
