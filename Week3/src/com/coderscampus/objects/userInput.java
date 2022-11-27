package com.coderscampus.objects;

public class userInput {

	String input;
	Integer convertedInput;
	Integer lowNumber;
	Integer highNumber;
	
	void setInfo (Integer lowNumber, Integer highNumber) {
		this.lowNumber = lowNumber;
		this.highNumber = highNumber;
	
	}
	
	String passing() {
		return ("The number you typed was " + convertedInput);
	}
	
	String failing() {
		return ("The number you typed was " + null);
	}
}
