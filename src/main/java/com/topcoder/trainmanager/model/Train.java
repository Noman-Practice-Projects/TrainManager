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
	@JsonProperty ("id")
	private long id;
	
	@NotNull
	@JsonProperty ("name")
	private String name;
	
	@NotNull
	@JsonProperty ("description")
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
	
	public void setNonNullAttributesFromMap(Map<String, Object> updatedTrain) {
		if (updatedTrain.containsKey("name")) {
			this.setName((String) updatedTrain.get("name"));
		}
		if (updatedTrain.containsKey("description")) {
			this.setDescription((String) updatedTrain.get("description"));
		}
		if (updatedTrain.containsKey("distance-between-stop")) {
			this.setDistanceBetweenStop((String) updatedTrain.get("distance-between-stop"));
		}
		if (updatedTrain.containsKey("max-speed")) {
			this.setMaxSpeed((String) updatedTrain.get("max-speed"));
		}
		if (updatedTrain.containsKey("sharing-tracks")) {
			this.setSharingTracks((boolean) updatedTrain.get("sharing-tracks"));
		}
		if (updatedTrain.containsKey("grade-crossing")) {
			this.setGradeCrossing((boolean) updatedTrain.get("grade-crossing"));
		}
		if (updatedTrain.containsKey("train-frequency")) {
			this.setTrainFrequency((String) updatedTrain.get("train-frequency"));
		}
		if (updatedTrain.containsKey("amenities")) {
			this.setAmenities((String) updatedTrain.get("amenities"));
		}
	}
}
