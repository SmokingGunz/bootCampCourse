package com.coderscampus.rpsgame;

import java.util.Random;
import java.util.Scanner;

public class Objects {

	public String rockPaperScissorsGame() {

		Scanner scanner = new Scanner(System.in);
		String[] computerInput = { "Rock", "Paper", "Scissor" };

		Random random = new Random();

		while (true) {
			Integer randomNumber = random.nextInt(2);
			String myInput = scanner.nextLine();

		}
	}
}
