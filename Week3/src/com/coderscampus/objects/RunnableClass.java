package com.coderscampus.objects;

public class RunnableClass {

	public static void main(String[] args) {
		System.out.println("TEST");
		
		// Class is a blueprint for an object
		// Object is a noun, its an instantiation of a class
		// Data type, variable name, assignment operation
		
		
		Human ericOwens = new Human();
		
		ericOwens.eyeColor = "green";
		ericOwens.gender = "male";
		ericOwens.height = "6'2\"";
		ericOwens.weight = "210";
		ericOwens.age = "36";
		ericOwens.hairColor = "brown";
		
		System.out.println(ericOwens);
		
		Human elonMusk = new Human();
		
		elonMusk.eyeColor = "blue";
		elonMusk.height = "6'1\"";
		elonMusk.weight = "190";
		
		System.out.println(elonMusk);
		

	}

}
