package com.coderscampus.lesson7;

public class WrapperExampleApplication {

	public static void main(String[] args) {

		/*
		 * byte    -> Byte
		 * short   -> Short
		 * int     -> Integer
		 * long    -> Long
		 * float   -> Float
		 * double  -> Double
		 * char    -> Character
		 * boolean -> Boolean
		 * 
		 * */
		
		int primitiveInt = 9;
		Integer wrapperInt = 9; // auto-boxing
		primitiveInt = new Integer(9);
		primitiveInt = Integer.valueOf(9); // un-boxing
		
		Integer anotherIntWrapper = Integer.valueOf(9);
		
		
		String someNumber = "123";
		String someOtherNumber = "456";
		Boolean someBoolean = null;
		
		// a safer way to do string comparison to avoid a NullPointerException
		if("456".equals(someNumber)) {
			
		}
		
		if(Boolean.TRUE.equals(someBoolean)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		System.out.println(someNumber + someOtherNumber);
		System.out.println(Integer.parseInt(someNumber) + Integer.parseInt(someOtherNumber));
		
		Integer someRandomNumber = Integer.parseInt(someNumber);
		
		long firstLong = 10L;
		long secondLong = 10L;
		
		if(firstLong == secondLong) {
			System.out.println("Primitive love comparison works");	
		}
		
		Long firstLongWrapper = new Long(10);
		Long secondLongWrapper = Long.valueOf(10);
		
		// Here is a typical "Gotcha" scenario.... when comparing object wrapper values, be sure to use .equals(), not ==
		if(firstLongWrapper.equals(secondLongWrapper)) {
			System.out.println("Object wrapper long comparison works");
		}

	}

}
