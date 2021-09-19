package com.topcoder.childhooddream.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The model Train.
 */
@Getter
@Setter
@Entity
@Table (name = "trains")
@NoArgsConstructor
public class Train {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	@Column (name = "\"distance-between-stop\"")
	@JsonProperty ("distance-between-stop")
	private String distanceBetweenStop;
	
	@Column (name = "\"max-speed\"")
	@JsonProperty ("max-speed")
	private String maxSpeed;
	
	@Column (name = "\"sharing-tracks\"")
	@JsonProperty ("sharing-tracks")
	private boolean sharingTracks;
	
	@Column (name = "\"grade-crossing\"")
	@JsonProperty ("grade-crossing")
	private boolean gradeCrossing;
	
	@Column (name = "\"train-frequency\"")
	@JsonProperty ("train-frequency")
	private String trainFrequency;
	
	private String amenities;
}
