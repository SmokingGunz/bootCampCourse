package com.coderscampus.lesson6;

import java.lang.reflect.Method;

public class AnnotationApplication {

	public static void main(String[] args) {

		AnnotationApplicationTest obj = new AnnotationApplicationTest();

		Method[] methods = AnnotationApplicationTest.class.getMethods();

		int testPass = 0;
		int testFail = 0;
		int testIgnored = 0;

		for (Method method : methods) {
			MyTest myTest = method.getAnnotation(MyTest.class);

			if (myTest != null) {
				try {
					if (myTest.enabled()) {
						method.invoke(obj);
						testPass++;
					} else {
						testIgnored++;
					}
				} catch (Exception e) {
					testFail++;
				}

			}
		}

		System.out.println("Test Passed: " + testPass);
		System.out.println("Test Failed: " + testFail);
		System.out.println("Test Ignored: " + testIgnored);

	}

}
