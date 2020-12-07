package com.ag.apidesign_;

import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

	private final CarService carService;

	public CarController(@Autowired CarService carService) {
		this.carService = carService;
	}

	@GetMapping
	public ResponseEntity<List<Car>> getAll() {
		//return empty list even if there is no any related entity
		List<Car> carList = carService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(carList);
	}

	@GetMapping("{id}")
	public ResponseEntity<Car> getById(@PathVariable String id) {
		return Optional.ofNullable(carService.getById(id))
				.map(car -> ResponseEntity.status(HttpStatus.OK).body(car))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ""));
//			Car car = carService.getById(id);
//			if(car == null) {
//				throw
//			} else {
//				return ResponseEntity.status(HttpStatus.SC_OK).body(car);
//			}

	}

	@PostMapping
	public ResponseEntity<Car> create(@RequestBody Car car) {
		try {
			Car createdCar = carService.create(car);

			//If you want to return entity, now probably has an id ot other fields
			return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);

			//If you don't want to return sth or explanation
			// return ResponseEntity.status(HttpStatus.SC_NO_CONTENT);
		} catch(IllegalStateException e) {
			// message contains details: invalid email, number etc.
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Car> update(@PathParam(value = "id") String id, @RequestBody Car car) {
		Car existingCar = carService.getById(id);
		if(existingCar != null) {
			Car createdCar = carService.create(car);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
		} else {
			try {
				Car updatedCar = carService.update(car);
				return ResponseEntity.status(HttpStatus.OK).body(updatedCar);
			} catch(IllegalStateException e) {//for some reason could not be updated
				throw new ResponseStatusException(HttpStatus.CONFLICT, "");
			}
		}
	}

	@DeleteMapping
	public ResponseEntity deleteAll() {
		carService.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteById(@PathVariable String id) {
		Car existingCar = carService.getById(id);
		if(existingCar != null) {
			carService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}

	//Asynchronous request
	@PostMapping("/race")
	public ResponseEntity startRace() {
		carService.startRace();

		//means request is accepted for processing but is not completed.
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Check: /v1/race/status");
	}

	//monitor status of race by polling
	@GetMapping("/race/status")
	public ResponseEntity<String> getRaceStatus() {
		String raceStatus = carService.getRaceStatus();
		return ResponseEntity.status(HttpStatus.OK).body(raceStatus);
	}
}
