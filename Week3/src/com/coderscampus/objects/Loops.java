package com.coderscampus.objects;

public class Loops {
	
	public static void main (String[] args) {
		
//		for loop example class code 
//		
		ForLoopExample example1 = new ForLoopExample();
//		example1.forLoopExample();
//		example1.incrementExample1();
		
		int j = 0;
		example1.incrementExample2(j++);
		System.out.println("Outside method j = " + j);
		example1.incrementExample2(++j);
		System.out.println("Outside method j = " + j);
		
		// while loop example code 
		
//		WhileLoopExample whileExample1 = new WhileLoopExample();
//		whileExample1.whileLoopExample1();
//		whileExample1.whileLoopExample2();
	}
	
}
