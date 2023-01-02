package com.coderscampus.lesson8;

public class StringManipulation {

	public static void main(String[] args) {

		for (String arg : args) {
			System.out.println(arg);

			String[] numbersArray = arg.split(",");
			for (String number : numbersArray) {
				System.out.println(number);
			}
		}

	}

}
