package com.skilldistillery.jets.game;

public interface Damagable {
	
	
	void destroy();
	
	default int calculateDamage(int defense, int damage) {
		defense -= damage;
		if(defense <= 0) {
			destroy();
		}
		return defense;
	}
	default int calculateRepairs(int defense, int repairs) {
		
		
		if(repairs <= 0) {
			return defense;
		}
		return defense += repairs;
	}

}
