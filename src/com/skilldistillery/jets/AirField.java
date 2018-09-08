package com.skilldistillery.jets;

public class AirField {

	private Jet[] jets;
	private final char AIRPLANE_CHAR = '\u2708';
	private final char FUEL_CHAR = '\u26FD';
	// ascii characters
	// green check mark \u2705
	// fuel tank U+26FD
	// cross swords U+2694
	// emoji plane taking off

	// constructors
	public AirField() {
		jets = new Jet[10];
	}

	public AirField(Jet[] jets) {
		super();
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

	public void addJet(Jet jet) {

		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				jets[i] = jet;
				break;
			}
		}
	}

	// other methods
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
		}
		printSpecialBorder(AIRPLANE_CHAR, 40);
	}

	public void flyAll() {
		printSpecialBorder(FUEL_CHAR, 20);
		for (Jet jet : jets) {

			if (jet != null) {
				jet.fly();
			}
		}
		printSpecialBorder(FUEL_CHAR, 20);
	}

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

	// helper methods
	private void printSpecialBorder(char lining, int length) {
		String border = "";

		for (int i = 0; i < length; i++) {
			border += lining + " ";
		}
		System.out.println(border);
	}

}
