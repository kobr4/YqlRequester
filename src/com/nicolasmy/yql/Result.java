package com.nicolasmy.yql;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Result {
	@JsonProperty("place")
	public List<Place> placeList;
	
	@JsonProperty("channel")
	public List<Channel> channel;
}
