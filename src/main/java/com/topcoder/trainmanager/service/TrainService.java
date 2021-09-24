package com.topcoder.trainmanager.service;

import com.topcoder.trainmanager.model.Train;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

public interface TrainService {
	
	void insertTrain(Map<String, Object> requestBody);
	
	List<Train> getAll(Specification<Train> specification);
	
	Train getById(long id);
	
	void updateTrain(long id, Map<String, Object> requestBody);
	
	void deleteTrain(long id);
}
