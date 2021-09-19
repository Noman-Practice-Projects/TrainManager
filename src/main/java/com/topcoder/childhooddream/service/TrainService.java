package com.topcoder.childhooddream.service;

import com.topcoder.childhooddream.model.Train;

import java.util.List;

public interface TrainService {
	
	List<Train> getAll();
	
	Train getById(long id);
	
//	List<Train> getTrainsWithSharingTracks();
//
//	List<Train> getTrainsWithAmenity(String amenity);
//
//	void deleteTrain(long id);
}
