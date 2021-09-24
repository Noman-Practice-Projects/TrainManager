package com.topcoder.trainmanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topcoder.trainmanager.error.TrainInsertFailedException;
import com.topcoder.trainmanager.error.TrainNotFoundException;
import com.topcoder.trainmanager.error.TrainUpdateFailedException;
import com.topcoder.trainmanager.model.Train;
import com.topcoder.trainmanager.repository.TrainRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TrainServiceImpl implements TrainService {
	
	private final TrainRepository trainRepository;
	
	public TrainServiceImpl(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	
	@Override
	public void insertTrain(Map<String, Object> requestBody) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Train train = objectMapper.convertValue(requestBody, Train.class);
			trainRepository.save(train);
		} catch (RuntimeException ignored) {
			throw new TrainInsertFailedException();
		}
	}
	
	public List<Train> getAll(Specification<Train> specification) {
		return trainRepository.findAll(specification);
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
	public void updateTrain(long id, Map<String, Object> requestBody) {
		Train train = getById(id);
		if (requestBody.containsKey("id")) {
			throw new TrainUpdateFailedException();
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.convertValue(requestBody, Train.class);
			train.setNonNullAttributesFromMap(requestBody);
			trainRepository.save(train);
		} catch (RuntimeException ignored) {
			throw new TrainUpdateFailedException();
		}
	}
	
	@Override
	public void deleteTrain(long id) {
		Train trainToDelete = getById(id);
		trainRepository.delete(trainToDelete);
	}
}
