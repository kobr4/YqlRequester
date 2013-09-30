package com.nicolasmy.yql;

import org.codehaus.jackson.annotate.JsonProperty;

public class Item {

	private Condition condition;

	public Condition getCondition() {
		return condition;
	}

	@JsonProperty("condition") 
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
}
