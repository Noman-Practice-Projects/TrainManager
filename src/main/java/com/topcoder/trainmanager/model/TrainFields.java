package com.topcoder.trainmanager.model;

public enum TrainFields {
	id,
	name,
	description,
	distanceBetweenStop("distance-between-stop", "\"distance-between-stop\""),
	maxSpeed("max-speed", "\"max-speed\""),
	sharingTracks("sharing-tracks", "\"sharing-tracks\""),
	gradeCrossing("grade-crossing", "\"grade-crossing\""),
	trainFrequency("train-frequency", "\"train-frequency\""),
	amenities;
	
	public final String json;
	public final String column;
	
	TrainFields() {
		this.json = this.toString();
		this.column = this.json;
	}
	
	TrainFields(String json, String column) {
		this.json = json;
		this.column = column;
	}
	
	public static TrainFields fromJson(String json) {
		for (TrainFields field : values()) {
			if (field.json.equals(json)) {
				return field;
			}
		}
		
		return null;
	}
}
