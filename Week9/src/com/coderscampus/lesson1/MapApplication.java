package com.coderscampus.lesson1;

import java.util.HashMap;
import java.util.Map;

public class MapApplication {

	public static void main(String[] args) {

		// Key = SSN
		// Value = Person's Name

		Map<Integer, String> people = new HashMap<>();

		// HashMaps store data as Key / Value Pairs (K, V)
		// Hover over element and hit F4 to see different options like
		// HashMap or LinkedHashMap etc.

		people.put(111111111, "Trevor Page");
		people.put(222222222, "Josh Someone");
		people.put(333333333, "Elon Musk");
		people.put(444444444, "Jane Doe");
		people.put(555555555, "Jeff Bezos");
		people.put(555555555, "John Doe");
		
		// When there is a duplicate Key with different Value it acts as an "update" wherein there is a new value. 

		System.out.println("Get data using an invalid key: ");
		System.out.println(people.get(123456789)); 
		
		System.out.println("Get data using an valid key: ");
		System.out.println(people.get(111111111));

		System.out.println("Get data using an valid key: ");
		System.out.println(people.get(555555555));
		
		people.remove(555555555);
		System.out.println("Get data using an invalid key: ");
		System.out.println(people.get(555555555));
	}

}
