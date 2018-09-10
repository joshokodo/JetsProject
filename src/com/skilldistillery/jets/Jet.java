package com.skilldistillery.jets;

public abstract class Jet {

	private String model;
	private double speed; // mph
	private int range;
	private long price;
	private Pilot pilot;

	// constructors
	public Jet() {
		model = setRandomModel();
		speed = getRandomInt(200, 700);
		range = getRandomInt(1000, 5000);
		price = getRandomLong(100000000, 500000000);
		pilot = new Pilot();
	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// toString
	@Override
	public String toString() {
		return pilot.toString() + "\n[model: " + model + " speed: " + speed + " range: " + range + " price: " + price + "]";
	}

	// setters and getters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	// other methods
	public void fly() {
		double hours = range / speed;
		System.out.println(this.toString());
		System.out.printf("Hours til' out of fuel: %.2f%n", hours);
		
	}

	public double getSpeedInMach() {
		return speed * 0.001303;
	}

	

	public void fight(FighterJet targetJet) {
		// TODO Auto-generated method stub
		
	}
	
	public String setRandomModel() {
		char[] letters = new char[26];
		int[] numbers = new int[26];
		
		for(int i = 0; i < letters.length; i++) {
			letters[i] = (char) ('A' + i);
			numbers[i] = i + 1;
		}
		
		int winner1 = getRandomInt(0, 25);
		int winner2 = getRandomInt(0, 25);
		
		return letters[winner1] + "-" + numbers[winner2];
	}
	
	public int getRandomInt(int min, int max){ 
		return ((int) (Math.random()*(max - min))) + min; 
	}
	public double getRandomDouble(double min, double max){ 
		return  (Math.random()*(max - min)) + min; 
	}
	
	public long getRandomLong(long min, long max){ 
		return  ((long)(Math.random()*(max - min))) + min; 
	}
	

	

}
