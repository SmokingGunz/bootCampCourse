package com.coderscampus.lesson2;

public abstract class GenericFactory { 
	// these are great when you have multiple child classes that will implement and inherit from the
	// abstract class that will all behave similarly.
	// But all need to define the abstract behavior in their own way i.e. CarFactory, PhoneFactory, WidgetFactory, ComputerFactory etc. 

	protected Integer totalCapacity;
	
	public abstract Product build(Part[] parts);
	
	public Integer getTotalCapacity() {
		return totalCapacity;
	}
	
}
