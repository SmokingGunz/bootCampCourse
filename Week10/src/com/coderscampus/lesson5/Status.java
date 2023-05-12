package com.coderscampus.lesson5;

public enum Status {

	ACTIVE("A"), 
	INACTIVE("I"), 
	DELETED("D");

	private String value;

	private Status(String value) {

		this.value = value;

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
