package com.nicolasmy.yql;

import org.codehaus.jackson.annotate.JsonProperty;

public class Query {
	@JsonProperty("results") 
	public Result result;
}
