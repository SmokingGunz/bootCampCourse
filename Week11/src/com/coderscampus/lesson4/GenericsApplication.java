package com.coderscampus.lesson4;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GenericsApplication {

	@Test
	public void generics_examples() {

		List<String> list = new ArrayList<>();

		list.add("first string value");
		list.add("second string value");
		list.add("E");

		for (int i = 0; i < list.size(); i++) {
			System.out.println((String) list.get(i));
		}

	}

	@Test
	public void generics_examples2() {

		MyPair<Integer, String> myPair = new MyPair<>(1, "one");
		myPair.getKey();
		myPair.getValue();

	}

	@Test
	public void specifying_generic_types_at_method_level() {

		String val = Transformer.join(1, 2.0);
		System.out.println(val);
	}

	@Test
	public void wildcard_in_generic_type() {
		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(5L);
		list.add(100L);

		String val = Transformer.join(list);
		System.out.println(val);
	}

}
