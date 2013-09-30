package com.nicolasmy.yql;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PlaceList {
	
	@JsonProperty("place")
	public List<Place> placeList;
	
}
