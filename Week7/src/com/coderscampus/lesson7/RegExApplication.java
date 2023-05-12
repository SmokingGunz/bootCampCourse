package com.coderscampus.lesson7;

public class RegExApplication {

	public static void main(String[] args) {

		// "valid" email address fake.email@gmail.com
		// invalid email address trevorcraftycodr.com
		// invalid email address trevor@craftycodr.thisisntarealdomain
		// valid email address: trevor@craftycodr.com
		// valid email address: trevor-page.2@gmail.com
		
		// valid
		inputMatchesRegexPattern("fake.email@gmail.com");
		// invalid (missing an @ symbol)
		inputMatchesRegexPattern("trevorcraftycodr.com");
		// invalid (domain extension is too long)
		inputMatchesRegexPattern("trevor@craftycodr.thisisntarealdomain");
		// valid
		inputMatchesRegexPattern("trevor@craftycodr.com");
		// valid 
		inputMatchesRegexPattern("trevor-page.2@gmail.com");
		// valid
		inputMatchesRegexPattern("Trevor@CraftyCodr.com");
		
	}

	private static void inputMatchesRegexPattern(String input) {
		boolean matchfound = input.matches("^[a-zA-Z0-9][a-zA-Z0-9-]{0,}\\.?[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{1,5}$");
		
		System.out.println("For Input " + input + " , match found = " + matchfound);
	}
	

}
