package com.nicolasmy.yql;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Condition {
	private String code;
	private String date;
	private Integer temp;
	private String text;
	
	public String getCode() {
		return code;
	}
	
	@JsonProperty("code") 
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	
	@JsonProperty("date") 
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getTemp() {
		return temp;
	}
	
	@JsonProperty("temp") 
	public void setTemp(Integer temp) {
		this.temp = temp;
	}
	public String getText() {
		return text;
	}
	
	@JsonProperty("text") 
	public void setText(String text) {
		this.text = text;
	}
}
