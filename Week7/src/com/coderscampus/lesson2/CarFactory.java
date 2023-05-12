package com.coderscampus.lesson2;

public class CarFactory extends GenericFactory{
	
	public CarFactory() {
		this.totalCapacity = 1000;
		
	}

	@Override
	public Product build(Part[] parts) {
		Body body = null;
		Frame frame = null;
		Electronics electronics = null;
		
		for (Part part : parts) {
			if(part instanceof Electronics) {
				electronics = (Electronics) part;
			}else if(part instanceof Frame) {
				frame = (Frame) part;
			}else if(part instanceof Body) {
				body = (Body) part;
			}
		}
		if (body != null && frame != null && electronics != null	) {
			Car car = new Car()	;
			car.setBody(body);
			car.setElectronics(electronics);
			car.setFrame(frame);
			return car;
		}
		return null;
	}
	

}
