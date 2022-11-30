package com.coderscampus.objects;

public class Human {
	String gender;
	String age;
	String eyeColor;
	String hairColor;
	String height;
	String weight;
	
	public Human () {
		System.out.println("A human is being created");
	}
	
	public Human (String gender, String height, String weight, String eyeColor)  {
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.eyeColor = eyeColor;
		
	}
	
	// (Visibility modifier), return type, method name, parameters, scope
	
	String getInfo () {
		return "Gender: " + gender + ", Height: " + height + ", Eye Color: " + eyeColor +
				", Weight: " + weight;
	}
	
	void setProperties (String gender, String height, String weight, String eyeColor) {
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.eyeColor = eyeColor;
		
	}
	
	
}
