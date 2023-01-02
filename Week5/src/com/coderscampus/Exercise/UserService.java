package com.coderscampus.Exercise;

public class UserService {

	public User createUser(String[] stringInputs) {

		String userName = stringInputs[0];
		String passWord = stringInputs[1];
		String name = stringInputs[2];
		User user = new User();
		user.setName(name);
		user.setPassWord(passWord);
		user.setUserName(userName);
		return user;

	}

	public String[] parseText(String inputs) {

		String input = inputs;
		String[] textParse = input.split(",");
		return textParse;

	}
}
