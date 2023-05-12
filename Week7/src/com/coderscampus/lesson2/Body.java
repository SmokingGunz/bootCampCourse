package com.coderscampus.lesson2;

public class Body implements Part {
	
	public Body() {
		System.out.println("A car Body is being constructed.");
	}

	@Override
	public Integer getSize() {
		return 20;
	}

	@Override
	public Integer getBuildTime() {
		return 5;
	}

}
