package com.coderscampus.lesson2;

public class GenericFactoryApplication {

	public static void main(String[] args) {

		GenericFactory carFactory = new CarFactory();
		Body body = new Body();
		Frame frame = new Frame();
		Electronics electronics = new Electronics();
		
		Part[] parts = new Part[3];
		parts[0] = body;
		parts[1] = frame;
		parts[2] = electronics;
		
		
		Product car = carFactory.build(parts);
		System.out.println("We've buld a new car: " + car);
		
	}

}
