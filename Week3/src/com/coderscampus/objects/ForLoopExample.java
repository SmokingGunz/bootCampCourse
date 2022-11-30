package com.coderscampus.objects;

public class ForLoopExample {

	void forLoopExample () {
		
		// init; termination condition; increment
		for (int i = 1; i <= 100; i = i +1) {
			System.out.print(i + ": ");
			System.out.println(i*i);
		}
		
		System.out.println("Done");
	}
	
	void incrementExample1 () {
		
		for (int j = 0; j < 10; j++) {
			System.out.println(j);
		}
		
		for (int j = 9; j >= 0; j--) {
			System.out.println(j);
		}
	}
	
	void incrementExample2 (int j) {
		System.out.println("Inside incrementExample2 method j = " + j);
		
	}
}
