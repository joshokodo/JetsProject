package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	// constructors
	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, long price) {
		this();
		setModel(model);
		setSpeed(speed);
		setRange(range);
		setPrice(price);

	}

	// toString
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "\n" + super.toString();
		
	}


	// other methods
	public void fight() {
		System.out.println("Hi im " + this.toString());
		System.out.println("Look at me, im fighing and junk at mach " + super.getSpeedInMach());

	}

}
