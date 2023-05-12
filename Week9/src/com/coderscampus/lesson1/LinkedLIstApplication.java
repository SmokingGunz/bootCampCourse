package com.coderscampus.lesson1;

import java.util.LinkedList;
import java.util.List;

public class LinkedLIstApplication {

	public static void main(String[] args) {

		List<Integer> numbers = new LinkedList<>();
		
		// LinkedList 
		// Head=1     Head=0     Head=0		 Head=0
		// Tail=0 <-> Tail=0 <-> Tail=0 <->  Tail=1
		// (10)        (20)       (30)  		  (40)
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		
		printListToConsole(numbers);
		
		numbers.remove(0);
		
		printListToConsole(numbers);
		
		numbers.remove((Integer)30);
		
		printListToConsole(numbers);
		
		
	}
	public static void printListToConsole(List<Integer> elements) {
		for (Integer element : elements) {
			System.out.println(element);
		}
		System.out.println("");
	}

}
