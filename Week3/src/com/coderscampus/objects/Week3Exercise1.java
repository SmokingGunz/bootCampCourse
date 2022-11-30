package com.coderscampus.objects;

import java.util.Scanner;

public class Week3Exercise1 {

	public static void main(String[] args) {
		
		UserInput number = new UserInput();
		
		number.setInfo(50, 300); 
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Type a number between " + number.lowNumber + " and " + number.highNumber);
		number.input = scanner.nextLine();
		number.convertedInput = Integer.parseInt(number.input);
		
		if (number.convertedInput < number.lowNumber || number.convertedInput > number.highNumber) {
			System.out.println(number.failing());
			
		}else {
			System.out.println(number.passing());
		}
		scanner.close();
	}

}
