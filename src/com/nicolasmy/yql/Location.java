package com.nicolasmy.yql;

import org.codehaus.jackson.annotate.JsonProperty;

public class Location {
	private String city;
	private String country;
	private String region;
	
	public String getCity() {
		return city;
	}
	
	@JsonProperty("city") 
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	@JsonProperty("country") 
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	@JsonProperty("region") 	
	public void setRegion(String region) {
		this.region = region;
	}
}
