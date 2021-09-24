package com.topcoder.trainmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * The model Train.
 */
@Getter
@Setter
@Entity
@Table (name = "trains")
@NoArgsConstructor
public class Train {
	
	@NotNull
	@Id
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@NotNull
	@Column (name = "\"distance-between-stop\"")
	@JsonProperty ("distance-between-stop")
	private String distanceBetweenStop;
	
	@NotNull
	@Column (name = "\"max-speed\"")
	@JsonProperty ("max-speed")
	private String maxSpeed;
	
	@NotNull
	@Column (name = "\"sharing-tracks\"")
	@JsonProperty ("sharing-tracks")
	private boolean sharingTracks;
	
	@NotNull
	@Column (name = "\"grade-crossing\"")
	@JsonProperty ("grade-crossing")
	private boolean gradeCrossing;
	
	@NotNull
	@Column (name = "\"train-frequency\"")
	@JsonProperty ("train-frequency")
	private String trainFrequency;
	
	@NotNull
	@JsonProperty ("amenities")
	private String amenities;
	
	public void setNonNullAttributesFromMap(Map<String, Object> updatedTrain) throws NoSuchFieldException, IllegalAccessException {
		for (TrainFields key : TrainFields.values()) {
			if (updatedTrain.containsKey(key.json)) {
				getClass().getDeclaredField(key.name()).set(this, updatedTrain.get(key.json));
			}
		}
	}
	
	@Override
	public String toString() {
		return "Train{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", distanceBetweenStop='" + distanceBetweenStop + '\'' +
				", maxSpeed='" + maxSpeed + '\'' +
				", sharingTracks=" + sharingTracks +
				", gradeCrossing=" + gradeCrossing +
				", trainFrequency='" + trainFrequency + '\'' +
				", amenities='" + amenities + '\'' +
				'}';
	}
}
