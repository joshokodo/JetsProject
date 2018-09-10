package com.skilldistillery.jets.game;

import com.skilldistillery.jets.AirField;
import com.skilldistillery.jets.Person;

public class General extends Person {
	
	private double budget;
	private AirField fleet;
	
	
	
	public General() {
		super();
		budget = 500_000_000;
		fleet = new AirField(5);
	}
	
	public General(String name, int age) {
		setName(name);
		setAge(age);
		fleet = new AirField(5);
		budget = 500_000_000;
		
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
	public void addToBudget(int money) {
		if(money < 0) {
			return;
		}
		budget += money;
	}
	public void subFromBudget(int money) {
		if(money < 0) {
			return;
		}
		budget = Math.abs(budget - money);
	}

	public int getFleetDefense() {
		return fleet.getDefense();
	}
	public void setFleetDefense(int defense) {
		fleet.setDefense(defense);
	}
	public void baseUnderFire(int damage) {
		
	}

}
