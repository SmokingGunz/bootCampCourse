package com.coderscampus.week2;

import java.util.Scanner;

public class Week2Example2 {

	public static void main (String[] args) {
		
		
		// this is just for teaching purpose /////////
		// java.lang is by default imported for us ///
		java.lang.String aString = "Hello world!"; ///
		String anotherString = "Another String!";  ///
		//////////////////////////////////////////////
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in your name: ");
		String name = scanner.nextLine();
		System.out.println("Type in your age: ");
		String age = scanner.nextLine();
		
		if (name.equals("Eric") 
				&& age.equals("36")) { //use double && to speed up code. If false before will skip everything else
			System.out.println("Holy cow it's me!");
		} else if (name.equals("Brian") 
				|| age.equals("27")) { // use double || to speed up code. if any apply will skip to output.
			System.out.println("Hello: " + name);
		} else {
			System.out.println("Hello " + name);
		}
		scanner.close();
	}
}
