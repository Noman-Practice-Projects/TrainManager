package com.topcoder.trainmanager.controller;

import com.topcoder.trainmanager.dto.GenericResponse;
import com.topcoder.trainmanager.model.Train;
import com.topcoder.trainmanager.service.TrainService;
import com.topcoder.trainmanager.util.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.topcoder.trainmanager.specification.TrainSpecifications.hasAmenity;
import static com.topcoder.trainmanager.specification.TrainSpecifications.isSharingTracks;
import static org.springframework.data.domain.Sort.Order;
import static org.springframework.data.jpa.domain.Specification.where;

@RestController
@RequestMapping ("/trains")
public class TrainController {
	
	TrainService trainService;
	
	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}
	
	/* ================================ CREATE ==================================== */
	
	@PostMapping ()
	public ResponseEntity<GenericResponse> insertTrain(@RequestBody Map<String, Object> requestBody) {
		trainService.insertTrain(requestBody);
		return new ResponseEntity<>(new GenericResponse("new train added successfully", null), HttpStatus.CREATED);
	}
	
	/* ================================ READ ==================================== */
	
	@GetMapping ()
	public ResponseEntity<Object>
	getAllTrains(
			@RequestParam (name = "amenities", required = false) String amenity,
			@RequestParam (name = "sort", defaultValue = "id,desc") String sorts,
			@RequestParam (name = "page", defaultValue = "0") int page,
			@RequestParam (name = "size", defaultValue = "3") int size
	) {
		List<Order> orders = SortOrder.ConstructSortOrders(sorts);
		Pageable pages = PageRequest.of(page, size, Sort.by(orders));
		Page<Train> trainPage = trainService.getAll(where(hasAmenity(amenity)), pages);
		if (!trainPage.isEmpty()) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("totalItems", trainPage.getTotalElements());
			response.put("trains", trainPage.getContent());
			response.put("totalPages", trainPage.getTotalPages());
			response.put("currentPage", trainPage.getNumber());
			return new ResponseEntity<>(response, HttpStatus.OK);
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
		List<Train> trainsWithSharingTracks = trainService.getAll(where(isSharingTracks(true)));
		return new ResponseEntity<>(trainsWithSharingTracks, HttpStatus.OK);
	}
	
	/* ================================ UPDATE ==================================== */
	
	@PutMapping ("/{id}")
	public ResponseEntity<GenericResponse>
	updateTrainById(
			@PathVariable ("id") long id,
			@RequestBody Map<String, Object> requestBody
	) {
		trainService.updateTrain(id, requestBody);
		return new ResponseEntity<>(new GenericResponse("train edited successfully", null), HttpStatus.OK);
	}
	
	/* ================================ DELETE ==================================== */
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<GenericResponse> deleteTrainById(@PathVariable ("id") long id) {
		trainService.deleteTrain(id);
		return new ResponseEntity<>(new GenericResponse("train removed successfully", null), HttpStatus.OK);
	}
}
