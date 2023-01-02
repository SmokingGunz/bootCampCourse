package com.coderscampus.Exercise;

public class UserApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		String[] userInput = { "eric", "1234", "Eric" };
		User user = userService.createUser(userInput);
		System.out.println(user);

		UserService userService1 = new UserService();
		String userInput1 = "exampleUsername,examplePassword,exampleName";
		String[] user1 = userService1.parseText(userInput1);

		for (String user2 : user1) {
			System.out.println(user2);
		}
	}

}
