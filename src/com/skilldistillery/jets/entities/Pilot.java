package com.skilldistillery.jets.entities;

public class Pilot extends Person {

	private int yearsOfExperience;
	

	public Pilot() {
		super();
		yearsOfExperience = getRandomInt(1, 10);
	}
	
	


	@Override
	public String toString() {
		return "Pilot " + super.toString() + "Years of experience:" + yearsOfExperience + "]";
	}




	public int getYearsOfExperience() {
		return yearsOfExperience;
	}


	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
	
	

}
