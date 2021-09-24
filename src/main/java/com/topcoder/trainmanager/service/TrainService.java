package com.topcoder.trainmanager.service;

import com.topcoder.trainmanager.model.Train;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

public interface TrainService {
	
	void insertTrain(Map<String, Object> requestBody);
	
	List<Train> getAll(Specification<Train> specification);
	
	Page<Train> getAll(Specification<Train> specification, Pageable pageable);
	
	Train getById(long id);
	
	void updateTrain(long id, Map<String, Object> requestBody);
	
	void deleteTrain(long id);
}
