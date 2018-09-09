package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	// constant strings for menu
	private final String MENU_BORDER = "****************************************\n";
	private final String SPACE = "*                                      *\n";
	
	private final String CUSTOM_JET_MENU =  "$$$$$$$$$$$$$$$$$$$$$$$$\n" 
											+ "$  1. Fighter Jet      $\n"
											+ "$  2. Cargo Plane      $\n"
											+ "$  3. Cancel           $\n"
											+ "$$$$$$$$$$$$$$$$$$$$$$$$\n"
											+ " Choose type of Plane to build: ";
	
	private AirField fleet;
	private Scanner keyboard;

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();
		app.launch();
	}

	// constructor
	private JetsApplication() {
		fleet = new AirField();
		keyboard = new Scanner(System.in);

		fleet.addJet(new FighterJet("F-22", 500.0, 3000, 375_000_000));
		fleet.addJet(new FighterJet("F-35", 300.0, 2500, 125_100_000));
		fleet.addJet(new FighterJet("A -10", 425.0, 2000, 125_000_000));
		fleet.addJet(new CargoPlane("AN-225", 200.0, 4000, 9_700_000));
		fleet.addJet(new CargoPlane("AN-124", 250.0, 5000, 25_000_000));

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
	private String getUserMenu() {
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
		returnValue += getMenuOption("9. Quit");
		returnValue += SPACE;
		returnValue += MENU_BORDER;
		returnValue += " Choose option from menu: ";

		return returnValue;
	}

	// returns a formatted menu option line
	private String getMenuOption(String option) {
		String returnValue = String.format("* %-37s*%n", option);
		return returnValue;
	}

	// prompts users with custom menu(arg 1) of choices
	// between a custom range(arg 2) returns choice in the form of an int
	private int getUserChoice(String prompt, int optionRange) {
		int choice = 0;
		boolean validChoice = false;

		while (true) {
			System.out.println();

			System.out.print(prompt);
			choice = getIntInput();

			validChoice = choice >= 1 && choice <= optionRange; // resets loop condition

			if (!validChoice) {
				System.out.println(" Not an available option. try again.");
				continue;
			} else {
				break;
			}
		}

		return choice;

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
			endProgram();
			break;

		default:
			break;

		}
	}

	// thanks user for using app, closes scanner and exits the app
	private void endProgram() {
		System.out.println("Thanks for using the app. have a great day");
		keyboard.close();
		System.exit(0);
	}

	// scanner input methods
	private int getIntInput() {
		int num = -1;

		while (true) {
			String stringChoice = keyboard.next();
			keyboard.nextLine(); // to get rid of any trailing texts

			try {
				num = Integer.parseInt(stringChoice);
			} catch (NumberFormatException e) {
				System.out.println(" Not a numeric choice. try again.");
				continue;
			}
			break;
		}
		return num;
	}

	private String getStringInput() {
		return keyboard.nextLine();
	}

	private double getDoubleInput() {
		double num = -1;

		while (true) {
			String stringChoice = keyboard.next();
			keyboard.nextLine(); // to get rid of any trailing texts

			try {
				num = Double.parseDouble(stringChoice);
			} catch (NumberFormatException e) {
				System.out.println(" Not a numeric choice. try again.");
				continue;
			}
			break;
		}
		return num;
	}

	private long getLongInput() {
		long num = -1;

		while (true) {
			String stringChoice = keyboard.next();
			keyboard.nextLine(); // to get rid of any trailing texts

			try {
				num = Long.parseLong(stringChoice);
			} catch (NumberFormatException e) {
				System.out.println(" Not a valid choice. try again.");
				continue;
			}
			break;
		}
		return num;
	}

}
