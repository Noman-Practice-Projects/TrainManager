package com.topcoder.childhooddream.service;

import com.topcoder.childhooddream.error.TrainNotFoundException;
import com.topcoder.childhooddream.model.Train;
import com.topcoder.childhooddream.repository.TrainRepository;
import org.springframework.stereotype.Service;

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
		trainRepository.findById(id).ifPresentOrElse(requiredTrain::set, () -> {
			throw new TrainNotFoundException();
		});
		return requiredTrain.get();
	}
	
//	@Override
//	public List<Train> getTrainsWithSharingTracks() {
//		return trainRepository.findAll().stream().filter(Train::isSharingTracks).collect(Collectors.toList());
//	}
//
//	@Override
//	public List<Train> getTrainsWithAmenity(String amenity) {
//		return null;
//	}
//
//	@Override
//	public void deleteTrain(long id) {
//		Train trainToDelete = getById(id);
//		trainRepository.delete(trainToDelete);
//		trainRepository.save(trainToDelete);
//	}
}
