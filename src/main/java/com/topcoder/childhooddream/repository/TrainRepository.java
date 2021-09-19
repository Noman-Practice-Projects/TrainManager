package com.topcoder.childhooddream.repository;

import com.topcoder.childhooddream.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Train repository.
 */
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
	
}
