package com.topcoder.bullettrain.service;

import com.topcoder.bullettrain.model.Train;

import java.util.List;

public interface TrainService {
	
	List<Train> getAll();
	
	Train getById(long id);
	
	List<Train> getTrainsWithSharingTracks();

	List<Train> getTrainsWithAmenities(List<String> amenities);

	void deleteTrain(long id);
}
