package com.coderscampus.lesson1;

import java.util.ArrayList;
import java.util.List;

public class StreamTutorial {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		populatePeopleData(people);
		
		people.stream()  // Stream<List<Person>>
						//	Intermediate operations: filter, map, flatmap, distinct
		
			// inputs : Person [John1] --> Person[John20], outputs: Person[John12] --> Person[John20]
			  .filter(person -> person.getSsn() > 10)
			  // inputs: Person[John12] --> Person[John20]
			  // outputs: John12 --> John20
			  .map(person -> person.getFirstName())
			  .forEach(System.out::println);  // terminal: foreEach, Collect, Reduce
	}

	public static void populatePeopleData(List<Person> people) {
		for (int i = 0; i < 20; i++) {
			Person person = new Person(i, "John" + (i + 1), "Doe" + (i + 1));
			people.add(person);
		}
	}

}
