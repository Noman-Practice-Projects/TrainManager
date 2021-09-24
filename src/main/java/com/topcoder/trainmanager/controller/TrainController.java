package com.topcoder.trainmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topcoder.trainmanager.dto.GenericResponse;
import com.topcoder.trainmanager.model.Train;
import com.topcoder.trainmanager.service.TrainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.topcoder.trainmanager.specification.TrainSpecifications.hasAmenity;
import static com.topcoder.trainmanager.specification.TrainSpecifications.isSharingTracks;
import static org.springframework.data.jpa.domain.Specification.where;

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
	
	@PostMapping ()
	public ResponseEntity<GenericResponse> insertTrain(@RequestBody Map<String, Object> requestBody) {
		trainService.insertTrain(requestBody);
		return new ResponseEntity<>(new GenericResponse("new train added successfully", null), HttpStatus.CREATED);
	}
	
	/* ================================ READ ==================================== */
	
	@GetMapping ()
	public ResponseEntity<Object> getAllTrains(@RequestParam (name = "amenities", required = false) String amenity) {
		List<Train> trains = trainService.getAll(where(hasAmenity(amenity)));
		if (trains.size() > 0) {
			return new ResponseEntity<>(trains, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new GenericResponse("train not found", null), HttpStatus.OK);
		}
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
	
	@PutMapping ("/{id}")
	public ResponseEntity<GenericResponse> updateTrainById(@PathVariable ("id") long id, @RequestBody Map<String, Object> requestBody) {
		trainService.updateTrain(id, requestBody);
		return new ResponseEntity<>(new GenericResponse("train edited successfully", null), HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<GenericResponse> deleteTrainById(@PathVariable ("id") long id) {
		trainService.deleteTrain(id);
		return new ResponseEntity<>(new GenericResponse("train removed successfully", null), HttpStatus.OK);
	}
}
