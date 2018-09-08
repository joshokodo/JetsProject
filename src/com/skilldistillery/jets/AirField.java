package com.skilldistillery.jets;

public class AirField {

	private Jet[] jets;
	
	public AirField() {
		jets = new Jet[10];
	}

	public AirField(int numOfJets) {
		jets = new Jet[numOfJets];
	}
	public AirField(Jet[] jets) {
		super();
		this.jets = jets;
	}
	
	
	
}
