package com.topcoder.trainmanager.service;

import com.topcoder.trainmanager.model.Train;

import java.util.List;

public interface TrainService {
	
	List<Train> getAll();
	
	Train getById(long id);
	
	List<Train> getTrainsWithSharingTracks();

	List<Train> getTrainsWithAmenities(String amenities);

	void deleteTrain(long id);
}
