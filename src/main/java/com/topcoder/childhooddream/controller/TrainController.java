package com.topcoder.childhooddream.controller;

import com.topcoder.childhooddream.model.Train;
import com.topcoder.childhooddream.service.TrainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Train controller.
 */
@RestController
@RequestMapping ("/trains")
public class TrainController {
	
	/**
	 * The Train repository.
	 */
	TrainService trainService;
	
	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}
	
	/**
	 * Gets all trains.
	 *
	 * @return the all trains
	 */
	@GetMapping ()
	public ResponseEntity<List<Train>> getAllTrains() {
		List<Train> trains = trainService.getAll();
		return new ResponseEntity<>(trains, HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Train> getTrainById(@PathVariable ("id") long id) {
		Train train = trainService.getById(id);
		return new ResponseEntity<>(train, HttpStatus.OK);
	}
}
