package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	// constructors
	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	// toString
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + super.toString();
	}

	// other methods
	public void fight() {
		System.out.println("Hi im " + this.toString());
		System.out.println("Look at me, im fighing and junk at mach " + super.getSpeedInMach());

	}

}
