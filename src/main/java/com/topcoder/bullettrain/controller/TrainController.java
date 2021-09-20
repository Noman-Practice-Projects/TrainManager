package com.topcoder.bullettrain.controller;

import com.topcoder.bullettrain.dto.GenericResponse;
import com.topcoder.bullettrain.model.Train;
import com.topcoder.bullettrain.service.TrainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping ("/sharing-tracks")
	public ResponseEntity<List<Train>> getTrainsWithSharingTracks() {
		List<Train> trainsWithSharingTracks = trainService.getTrainsWithSharingTracks();
		return new ResponseEntity<>(trainsWithSharingTracks, HttpStatus.OK);
	}
	
	@GetMapping ("/amenity")
	public ResponseEntity<Object> getTrainsWithAmenity(@RequestParam (value = "keyword") String amenity) {
		List<Train> trains = trainService.getTrainsWithAmenities(amenity);
		if (trains.size() > 0) {
			return new ResponseEntity<>(trains, HttpStatus.OK);
		}
		return new ResponseEntity<>(new GenericResponse("train not found", null), HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<GenericResponse> deleteTrainById(@PathVariable ("id") long id) {
		trainService.deleteTrain(id);
		return new ResponseEntity<>(new GenericResponse("train removed successfully", null), HttpStatus.OK);
	}
}
