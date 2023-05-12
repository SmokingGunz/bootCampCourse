package com.coderscampus.lesson1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApplication {

	public static void main(String[] args) {

		Set<Person> people = new HashSet<>();
		
		people.add(new Person(111111111, "Trevor", "Page"));
		people.add(new Person(111111111, "Trevor", "Page"));
		people.add(new Person(111111112, "Trevor", "Page"));

		
		for (Person person : people) {
			System.out.println(person);
		}
		
		// example1();
		
		
	}

	public static void example1() {
		Set<Integer> uniqueNumbers = new LinkedHashSet<>();

		uniqueNumbers.add(1);
		uniqueNumbers.add(2);
		uniqueNumbers.add(3);
		uniqueNumbers.add(4);
		uniqueNumbers.add(5);
		uniqueNumbers.add(6);
		uniqueNumbers.add(1);

		// returns boolean for each add operation. If you System.out.println on each it
		// would be either true or false.
		// Set cannot have repeated entries ie. 1 cannot repeat.
		// Set stores entries in order of entry.

		printSetToConsole(uniqueNumbers);

		Set<String> uniqueNames = new HashSet<>();
		
		// HashSet does not keep order like LinkedHashSet. 
		
		uniqueNames.add("Trevor Page");
		uniqueNames.add("Elon Musk");
		uniqueNames.add("Jane Doe");
		uniqueNames.add("Josh Someone");
		
		for (String element : uniqueNames) {
			System.out.println(element);
		}
	}

	public static void printSetToConsole(Set<Integer> elements) {
		for (Integer element : elements) {
			System.out.println(element);
		}
		System.out.println("");
	}

}
