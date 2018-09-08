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

	}

}
