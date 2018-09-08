package com.skilldistillery.jets;

public class AirField {

	private Jet[] jets;
	
	
	// constructors
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

		
		for(int i = 0; i < jets.length; i++) {
			if(jets[i] == null) {
				jets[i] = jet;
				break;
			}
		}
	}
	
	// other methods
	public void listJets() {
		int length = jets.length;
		
		if(length <= 0) {
			System.out.println("No jets in the fleet");
			return;
		}
		
		for(int i = 0; i < length; i++) {
			if(jets[i] != null) {
				
				System.out.println((i+1) + ": " + jets[i].toString());
			}
		}
	}
	
	
	
	
}
