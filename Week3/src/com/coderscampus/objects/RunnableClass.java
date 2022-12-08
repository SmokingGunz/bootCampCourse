package com.coderscampus.objects;

import java.util.Random;

public class RunnableClass {

	public static void main(String[] args) {
		
		// Class is a blueprint for an object
		// Object is a noun, its an instantiation of a class
		// Data type, variable name, assignment operation
		
		Random random = new Random();
		
		for (int i = 0; i<20; i++ ) {
			System.out.println("Random number is " + random.nextInt(10));
		}
		
		// call the for arg constructor
		Human someOtherHuman = new Human("brown", "5' 10\"", "160", "brown");
		System.out.println(someOtherHuman.getInfo());
		
		// call the no arg constructor
		Human ericOwens = new Human();
		
		ericOwens.eyeColor = "green";
		ericOwens.gender = "male";
		ericOwens.height = "6'2\"";
		ericOwens.weight = "210";
		ericOwens.age = "36";
		ericOwens.hairColor = "brown";
		
		System.out.println(ericOwens.getInfo());
		
		Human elonMusk = new Human();
		
		elonMusk.eyeColor = "blue";
		elonMusk.height = "6'1\"";
		elonMusk.weight = "190";
		elonMusk.gender = "male";
		
		
		System.out.println(elonMusk.getInfo());
		
		Human christinaPage = new Human();
		
		christinaPage.setProperties("female", "5'5\"", "130", "brown");
		// this is doing the exact same thing as the previous Human objects just using the method created
		// in the human class
		
		System.out.println(christinaPage.getInfo());
		

	}

}
