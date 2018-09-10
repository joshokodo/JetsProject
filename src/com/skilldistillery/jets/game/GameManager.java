package com.skilldistillery.jets.game;

import com.skilldistillery.jets.Menu;

public class GameManager implements Menu{
	
	
	private int days;
	private General player;
	private General enemy;
	
	private boolean playerOnOffense;
	
	
	public GameManager() {
		days = 1;
		enemy = new General();
		player = null;
		playerOnOffense = true;
	}
	
	public void runGame() {
		
		int choice = -1;
		
		System.out.print("Enter your name: ");
		String name = getStringInput();
		
		System.out.println("Enter your age: ");
		int age = getIntInput();
		
		this.player = new General(name, age);
		
		choice = getUserChoice(getUserMenu(), 2);
		
		
		
	}
	
	public String getUserMenu() {
		String returnValue = MENU_BORDER;
		returnValue += SPACE;
		returnValue += getMenuHeader("Good Morning, General!!!");
		returnValue += getMenuHeader("Day " + days + " morning report");
		returnValue += getMenuHeader("Your fleet defense : " + player.getFleetDefense());
		returnValue += getMenuHeader("Your enemy's fleet defense : " + enemy.getFleetDefense());
		returnValue += SPACE;
		returnValue += getMenuOption("1. examine your fleet");
		returnValue += SPACE;
		returnValue += getMenuOption(playerOnOffense ? "2. attack enemy base" 
													 : "2. block enemy attack");
		returnValue += SPACE;
		returnValue += getMenuOption("8. Add a jet to Fleet");
		returnValue += SPACE;
		returnValue += getMenuOption("9. Quit");
		returnValue += SPACE;
		returnValue += MENU_BORDER;
		returnValue += " Choose option from menu: ";

		return returnValue;
	}
	
	
	

}
