package com.skilldistillery.jets;

import com.skilldistillery.jets.game.Damagable;

public class FighterJet extends Jet implements CombatReady, Damagable {

	private int firePower;
	private int defense;
	private boolean isDestroyed;
	
	{
		isDestroyed = false;
		
	}
	
	
	
	// constructors
	public FighterJet() {
		super();
		firePower = getRandomInt(10, 1);
		defense = getRandomInt(10, 20);
		isDestroyed = false;
		
		
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
		String info = this.getClass().getSimpleName() + "\n" + super.toString();
		info += "\nFirePower: " + firePower +" Defense: " + defense;
		return info;
	}

	// setters and getters

	public int getFirePower() {
		return firePower;
	}

	public void setFirePower(int firePower) {
		this.firePower = firePower;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defensive) {
		this.defense = defensive;
	}

	
	// other methods
		public void fight() {
			System.out.println("Hi im " + this.toString());
			System.out.println("Look at me, im fighing and junk at mach " + super.getSpeedInMach());

		}

	@Override
	public void fight(FighterJet targetJet) {
		
		if(targetJet == null) {
			System.out.println("No bird to fight");
			return;
		}
		
		FighterJet first = null;
		FighterJet second = null;
		
		if(getSpeed() == targetJet.getSpeed()) {
			int winner = ((int) (Math.random()*(2 - 1))) + 1;
			if(winner == 1) {
				first = this;
				second = targetJet;
			}
			else {
				first = targetJet;
				second = this;
			}
		}
		else if(getSpeed() > targetJet.getSpeed()) {
			
			first = this;
			second = targetJet;
		}
		else {
			first = targetJet;
			second = this;
		}
		
		first.dealDamage(second);
		
		if(second.isDestroyed) {
			return;
		}
		
		second.dealDamage(first);
		
		
		
		
	}
	
	public void dealDamage(FighterJet target) {
		target.takeDamage(firePower);
	}
	
	public void takeDamage(int damage) {
		defense = calculateDamage(defense, damage);
	}
	public void repairDamage(int repairs) {
		defense = calculateRepairs(defense, repairs);
	}

	// implemented methods
	@Override
	public void destroy() {
		isDestroyed = true;
		
	}
	
	

	


}
