package com.topcoder.trainmanager.service;

import com.topcoder.trainmanager.model.Train;

import java.util.List;
import java.util.Map;

public interface TrainService {
	
	void insertTrain(Map<String, Object> requestBody);
	
	List<Train> getAll();
	
	Train getById(long id);
	
	List<Train> getTrainsWithSharingTracks();
	
	List<Train> getTrainsWithAmenities(String amenities);
	
	void updateTrain(long id, Map<String, Object> requestBody);
	
	void deleteTrain(long id);
}
