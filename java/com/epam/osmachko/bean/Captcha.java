package com.epam.osmachko.bean;

public class Captcha {

	
	private String value;
	
	private Long creationTime;
	
	
	public Captcha() {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}
	

	
	
}
