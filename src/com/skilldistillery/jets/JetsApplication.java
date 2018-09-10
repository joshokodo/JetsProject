package com.skilldistillery.jets;

import java.util.Scanner;

import com.skilldistillery.jets.game.GameManager;

public class JetsApplication implements Menu{

	// constant string for add custom jet menu                             
	private final String CUSTOM_JET_MENU =  "$$$$$$$$$$$$$$$$$$$$$$$$\n" 
											+ "$  1. Fighter Jet      $\n"
											+ "$  2. Cargo Plane      $\n"
											+ "$  3. Cancel           $\n"
											+ "$$$$$$$$$$$$$$$$$$$$$$$$\n"
											+ " Choose type of Plane to build: ";
	
	private AirField fleet;
	

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();
		app.launch();
	}

	// constructor
	private JetsApplication() {
		fleet = new AirField(5);
	


	}

	// launch app method
	private void launch() {
		int choice = 0;

		while (true) {
			choice = getUserChoice(getUserMenu(), 9);
			System.out.println();
			performOption(choice);

		}
	}

	// other methods

	// alternate version of displayUserMenu that returns a string of menu
	// use as arg for getUserChoice method
	public String getUserMenu() {
		String returnValue = MENU_BORDER;
		returnValue += SPACE;
		returnValue += getMenuOption("1. List fleet");
		returnValue += SPACE;
		returnValue += getMenuOption("2. Fly all jets");
		returnValue += SPACE;
		returnValue += getMenuOption("3. View fastest jet");
		returnValue += SPACE;
		returnValue += getMenuOption("4. View jet with longest range");
		returnValue += SPACE;
		returnValue += getMenuOption("5. View most expensive jet");
		returnValue += SPACE;
		returnValue += getMenuOption("6. Load all cargo jets");
		returnValue += SPACE;
		returnValue += getMenuOption("7. DogFight");
		returnValue += SPACE;
		returnValue += getMenuOption("8. Add a jet to Fleet");
		returnValue += SPACE;
		
		//game option coming soon.
//		returnValue += getMenuOption("9. Would you like to play a game?");
//		returnValue += SPACE;
		
		returnValue += getMenuOption("0. Quit");
		returnValue += SPACE;
		returnValue += MENU_BORDER;
		returnValue += " Choose option from menu: ";

		return returnValue;
	}


	

	// prompts user for what type of jet to build
	// then asks for all of its fields, builds the
	// specified jet object and adds it to fleet.
	private void addCustomJet() {

		if (hangerFull()) {
			System.out.println("Can't add jet. Hanger full");
			return;
		}

		int choice = getUserChoice(CUSTOM_JET_MENU, 3);

		if (choice == 3) {
			return;
		}
		System.out.print(" Enter Model: ");
		String model = getStringInput();

		System.out.print(" Enter Speed: ");
		double speed = getDoubleInput();

		System.out.print(" Enter Range: ");
		int range = getIntInput();

		System.out.print(" Enter Price: ");
		long price = getLongInput();

		if (choice == 2) {
			fleet.addJet(new CargoPlane(model, speed, range, price));
		} else if (choice == 1) {
			fleet.addJet(new FighterJet(model, speed, range, price));
		}
		System.out.println("\nJet added to Fleet.");

	}

	// helper method that checks if airfield is maxed out
	// on jet objects
	private boolean hangerFull() {
		for (Jet jet : fleet.getJets()) {
			if (jet == null) {
				return false;
			}
		}
		return true;
	}

	// takes in a choice in the form of an int and performs
	// the selected option
	private void performOption(int choice) {

		switch (choice) {
		case 0:
			endProgram();
			break;
			
		case 1:
			fleet.listJets();
			break;

		case 2:
			fleet.flyAll();
			break;

		case 3:
			System.out.println("Fastest jet is...");
			System.out.println(fleet.findCertainJet("SPEED"));

			break;

		case 4:
			System.out.println("Jet with the longest range is...");
			System.out.println(fleet.findCertainJet("RANGE"));
			break;

		case 5:
			System.out.println("Most expensive jet... ");
			System.out.println(fleet.findCertainJet("PRICE"));
			break;

		case 6:
			fleet.loadAllTheCargo();
			break;

		case 7:
			fleet.fightAllTheFights();
			break;

		case 8:
			addCustomJet();
			break;

		case 9:
			GameManager game = new GameManager();
			game.runGame();
			break;

		default:
			break;

		}
	}

	// thanks user for using app, closes scanner and exits the app
	public void endProgram() {
		System.out.println("Thanks for using the app. have a great day");
		closeKeyboard();
		System.exit(0);
	}

	

}
