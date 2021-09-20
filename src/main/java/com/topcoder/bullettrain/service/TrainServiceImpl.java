package com.topcoder.bullettrain.service;

import com.topcoder.bullettrain.error.TrainNotFoundException;
import com.topcoder.bullettrain.model.Train;
import com.topcoder.bullettrain.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements TrainService {
	
	TrainRepository trainRepository;
	
	public TrainServiceImpl(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	
	@Override
	public List<Train> getAll() {
		return trainRepository.findAll();
	}
	
	@Override
	public Train getById(long id) {
		AtomicReference<Train> requiredTrain = new AtomicReference<>();
		trainRepository.findById(id).ifPresent(requiredTrain::set);
		if (requiredTrain.get() == null) {
			throw new TrainNotFoundException();
		}
		return requiredTrain.get();
	}
	
	@Override
	public List<Train> getTrainsWithSharingTracks() {
		return trainRepository.findAll().stream().filter(Train::isSharingTracks).collect(Collectors.toList());
	}
	
	@Override
	public List<Train> getTrainsWithAmenities(List<String> amenities) {
		return new ArrayList<>();
	}
	
	@Override
	public void deleteTrain(long id) {
		Train trainToDelete = getById(id);
		trainRepository.delete(trainToDelete);
	}
}
