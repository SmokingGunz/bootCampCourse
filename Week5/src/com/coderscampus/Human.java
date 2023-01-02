package com.coderscampus;

public class Human {

	// class variable (have the word static, can be accessed by an instance, if variable stays the same across the board its static)
	static int TEENAGER_AGE = 13;
	static int ADULT_AGE = 19;
	static int SENIOR_AGE = 65;
	
	// instance variable (do not have the word static, are specific to the instance, if variable depends on the instance and can change
	// it is a non static variable)
	private int age;
	
	public int getAge () {
		return age;
	}
	
	public void setAge (int age) {
		
		if (age < 0 || age > 150) {
			System.out.println("No no no, thats not a valid age. A valid age is between 0 and 130");
			return;
		}
		this.age = age;
	}
	
	
	public String getStageOfLife() {
		if (age < TEENAGER_AGE) {
			return "Child";
		} else if (age < ADULT_AGE) {
			return "Teenager";
		} else if (age < 65) {
			return "Adult";
		} else {
			return "Senior";
		}
	}
}
