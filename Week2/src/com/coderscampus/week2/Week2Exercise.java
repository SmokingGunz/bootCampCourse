package com.coderscampus.week2;

import java.util.Scanner;

public class Week2Exercise {

	public static void main (String[] args) {
		
		int smallNumber = 50;
		int bigNumber = 300;
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Guess a number between 1 and 500:");
		String input = scanner.nextLine();
		Integer convertedInput = Integer.parseInt(input);
		
		if (convertedInput < smallNumber) {
			System.out.println("Wrong! Sorry you lose!");
		}
		else if (convertedInput > bigNumber) {
			System.out.println("No! Sorry you lose!");
		}
		else {
			System.out.println("Congratulations! You Win!");
		}
	}
	
	
}
