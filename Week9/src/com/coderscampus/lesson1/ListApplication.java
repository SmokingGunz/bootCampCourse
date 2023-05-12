package com.coderscampus.lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListApplication {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();

		names.add("Trevor Page");
		names.add("John Doe");
		names.add("Jane Doe");
		names.add("Elon Musk");
		names.add("Jeff Bezos");

		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		/**
		 * Lambda is a method signature to the left of the "->" and a block of code or a
		 * return statement. they can only be used with a functional interface; meaning
		 * an interface that using the functional interface annotation and defines 1 and
		 * only 1 abstract method inside of it.
		 * 
		 **/

		// This is a lambda expression basically the same this as writing out this ^^^

		Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

		// Lambda example 2, slightly more "verbose"

		Collections.sort(names, (String o1, String o2) -> o2.compareTo(o1));

		// example 3, even MORE "verbose", note: not the same functionality as above
		// because we are doing some null checks.

		Collections.sort(names, (String o1, String o2) -> {

			if (o2 != null && o1 != null) {
				return o2.compareTo(o1);
			} else {
				return 0;
			}

		});

		printArrayListToConsole(names);

//		example1();

	}

	public static void example1() {
		String[] names = new String[5];

		names[0] = "Trevor Page";
		names[1] = "Jane Doe";
		names[2] = "John Doe";
		names[3] = "Elon Musk";
		names[4] = "Jeff Bezos";

		names[1] = null;

		System.out.println("Arrays Example:" + "\n");

		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("----------------");
		System.out.println("");

		// Collections -> Java solution to common data structure problems.
		// List (a type of Collection)
		// Set (a type of Collection)
		// Map (a type of Collection)

		List<String> elements = new ArrayList<String>();

		elements.add("Trevor Page");
		elements.add("John Doe");
		elements.add("Jane Doe");
		elements.add("Elon Musk");
		elements.add("Jeff Bezos");

		System.out.println("List example: " + "\n");
		printArrayListToConsole(elements);

		elements.remove(1);

		printArrayListToConsole(elements);

		elements.remove("Trevor Page");

		printArrayListToConsole(elements);
	}

	public static void printArrayListToConsole(List<String> elements) {
		for (String element : elements) {
			System.out.println(element);
		}
		System.out.println("");
	}

}
