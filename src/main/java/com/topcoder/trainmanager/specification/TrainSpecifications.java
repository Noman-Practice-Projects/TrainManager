package com.topcoder.trainmanager.specification;

import com.topcoder.trainmanager.model.Train;
import org.springframework.data.jpa.domain.Specification;

public class TrainSpecifications {
	
	public static Specification<Train> hasAmenity(String amenity) {
		return amenity == null ? null : ((train, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(train.get("amenities"), "%" + amenity + "%"));
	}
	
	public static Specification<Train> isSharingTracks(boolean isSharingTracks) {
		return (train, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(train.get("sharingTracks"), isSharingTracks);
	}
}
