package com.skilldistillery.jets;

import com.skilldistillery.jets.game.Damagable;

public class AirField implements Damagable{

	private Jet[] jets;
	private Pilot[] pilots;
	private int defense;
	private boolean isDestroyed;
	
	{
		isDestroyed = false;
		defense = 100;
	}
	

	// special chars for borders
	private final char AIRPLANE_CHAR = '\u2708';
	private final char PACKAGE_CHAR = '\u2709';
	private final char SWORDS_CHAR = '\u2694';

	// constructors
	public AirField() {
		jets = new Jet[10];
		pilots = new Pilot[10];
		
	}

	public AirField(int start) {
		this();
		for (int i = 0; i < jets.length && i < start; i++) {

			if (i <= (start / 2)) {
				jets[i] = new FighterJet();

			} else {
				jets[i] = new CargoPlane();
			}
			pilots[i] = jets[i].getPilot();
		}
	}

	public AirField(Jet[] jets) {
		this();
		this.jets = jets;
	}

	// setters and getters
	public Jet[] getJets() {
		return jets;
	}

	public Jet getJet(int index) {
		return jets[index];
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Pilot[] getPilots() {
		return pilots;
	}

	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}

	

	
	// other methods
	public void addJet(Jet jet) {

		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				jets[i] = jet;
				break;
			}
		}
		addPilot(jet.getPilot());
	}

	public void addPilot(Pilot pilot) {

		for (int i = 0; i < pilots.length; i++) {
			if (pilots[i] == null) {
				pilots[i] = pilot;
				break;
			}
		}
	}
	
	// prints out all jets info and empty slots in the
	// jets array
	public void listJets() {
		int length = jets.length;

		if (length <= 0) {
			System.out.println("No jets in the fleet");
			return;
		}

		printSpecialBorder(AIRPLANE_CHAR, 40);
		for (int i = 0; i < length; i++) {

			if (jets[i] != null) {
				System.out.println((i + 1) + ": " + jets[i].toString());
			} else {
				System.out.println((i + 1) + ": " + "Empty slot");
			}
			System.out.println();
		}
		printSpecialBorder(AIRPLANE_CHAR, 40);
	}

	// calls the fly method for each jet in the jets array
	public void flyAll() {
		printSpecialBorder(AIRPLANE_CHAR, 20);
		for (Jet jet : jets) {

			if (jet != null) {
				jet.fly();
				System.out.println();
			}
		}
		printSpecialBorder(AIRPLANE_CHAR, 20);
	}

	// takes in an String arg and looks for the jet
	// with the highest value of the specified fields
	// speed, range or price
	public Jet findCertainJet(String target) {
		Jet certainJet = null;

		if (target.equalsIgnoreCase("SPEED")) {

			double fastestSpeed = 0;
			for (Jet jet : jets) {

				if (jet != null && jet.getSpeed() > fastestSpeed) {
					fastestSpeed = jet.getSpeed();
					certainJet = jet;
				}
			}

		} else if (target.equalsIgnoreCase("RANGE")) {

			int largestRange = 0;
			for (Jet jet : jets) {

				if (jet != null && jet.getRange() > largestRange) {
					largestRange = jet.getRange();
					certainJet = jet;
				}
			}

		} else if (target.equalsIgnoreCase("PRICE")) {

			long mostExpensive = 0;
			for (Jet jet : jets) {

				if (jet != null && jet.getPrice() > mostExpensive) {
					mostExpensive = jet.getPrice();
					certainJet = jet;
				}
			}
		}
		return certainJet;
	}

	public void loadAllTheCargo() {
		printSpecialBorder(PACKAGE_CHAR, 40);
		for (Jet jet : jets) {
			if (jet != null && jet.getClass() == new CargoPlane().getClass()) {
				((CargoCarrier) jet).loadCargo();
				System.out.println();
			}
		}
		printSpecialBorder(PACKAGE_CHAR, 40);
	}

	public void fightAllTheFights() {
		printSpecialBorder(SWORDS_CHAR, 40);
		for (Jet jet : jets) {
			if (jet != null && jet.getClass() == new FighterJet().getClass()) {
				((FighterJet) jet).fight();
				System.out.println();
			}
		}
		printSpecialBorder(SWORDS_CHAR, 40);
	}

	// helper methods

	// takes in a char for arg 1 and prints it on a line
	// with spaces between the amount passed for arg 2
	private void printSpecialBorder(char lining, int length) {
		String border = "";

		for (int i = 0; i < length; i++) {
			border += lining + " ";
		}
		System.out.println(border);
	}

	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	public void takeDamage(int damage) {
		defense = calculateDamage(defense, damage);
	}

}
