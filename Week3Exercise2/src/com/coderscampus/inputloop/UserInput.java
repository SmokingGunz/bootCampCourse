package com.coderscampus.inputloop;

import java.util.Scanner;

public class UserInput {
	

	public void userInput (){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a number betwen 50 and 300");
		
		while (true) {
			Integer input = scan.nextInt();
			
		if (input < 50 || input > 300) {
		System.out.println("Oops, that number wasns't between 50 and 300, try again: ");
			
		}else {
		System.out.println("The number you typed in was " + input);
		break;
		}
		
	}
}
	
	void userInput2() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a number between 50 and 300: ");
		String input = scan.nextLine();
		Integer convertedInput = Integer.parseInt(input);
		
		Integer i = convertedInput;
		while(i < 50 || i > 300) {
			System.out.println("Oops, that number wasn't between 50 and 300, try again: ");
			String next = scan.nextLine();
			Integer convert = Integer.parseInt(next);
			i = convert;
		}
		System.out.println("The number you typed in was " + i);
	scan.close();
	}
}
