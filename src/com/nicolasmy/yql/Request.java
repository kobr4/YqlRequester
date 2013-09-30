package com.nicolasmy.yql;

import org.codehaus.jackson.annotate.JsonProperty;

public class Request {
	
	@JsonProperty("query") 
	public Query query;
}
