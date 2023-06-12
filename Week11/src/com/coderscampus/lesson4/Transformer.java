package com.coderscampus.lesson4;

import java.util.List;
import java.util.stream.Collectors;

public class Transformer {
	
	public static <T1, T2> String join (T1 v1, T2 v2) {
		return v1.toString() + " -> " + v2.toString();
		
	}
	
	public static String join(List<? extends Number> list) {
		return list.stream().map(Number::toString).collect(Collectors.joining("\n"));
	}

}
