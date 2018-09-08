package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	// constructors
	public CargoPlane() {
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	// toString
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + super.toString();
	}

	// other methods
	public void loadCargo() {

	}

}
