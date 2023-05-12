package com.coderscampus.lesson5;

import java.util.Comparator;

public class PersonHeightComparator implements Comparator<Person>{

	@Override
	public int compare(Person person1, Person person2) {
		return person1.getHeight().compareTo(person2.getHeight());
	}

}
