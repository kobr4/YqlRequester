package com.nicolasmy.yql;

import org.codehaus.jackson.annotate.JsonProperty;

public class Channel {
	private Location location;
	private Item item;
	
	public Location getLocation() {
		return location;
	}
	
	@JsonProperty("location") 
	public void setLocation(Location location) {
		this.location = location;
	}
	public Item getItem() {
		return item;
	}
	
	@JsonProperty("item") 
	public void setItem(Item item) {
		this.item = item;
	}
}
