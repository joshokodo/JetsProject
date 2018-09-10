package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	// constructors
	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, long price) {
		
		super(model, speed, range, price);
	}

	// toStringsss
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "\n" + super.toString();
	}

	// other methods
	public void loadCargo() {
		System.out.println("Hi im " + this.toString());
		System.out.println("Look at me, im loading cargo and stuff at mach " + super.getSpeedInMach());
	}

}
