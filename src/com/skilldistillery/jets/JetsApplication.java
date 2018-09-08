package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	// constant strings for menu
	private final String MENU_BORDER = "****************************************\n";
	private final String SPACE = "*                                      *\n";
	private final String CONTINUE_MENU = "????????????????????????\n" 
									   + "?  1. return to menu   ?\n"
									   + "?  2. Quit             ?\n"
									   + "????????????????????????\n"
									   + " Choose option from menu: ";
	
	
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

	// other methods
	private void launch() {
		int choice = 0;
		// TODO decide if using days or not
		// int dayCounter = 1;

		while (true) {
			// System.out.println("Day " + dayCounter);
			choice = getUserChoice(getUserMenu(), 9);
			System.out.println();
			performOption(choice);

			choice = getUserChoice(CONTINUE_MENU, 2);
			continueLoop(choice);
			// dayCounter++;

		}
	}

	private void continueLoop(int choice) {

		if (choice == 1) {
			return;
		} else {
			endProgram();
		}
	}

	// alternate version of displayUserMenu that returns a string of menu
	// use as para. for getUserChoice method
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

	private int getUserChoice(String prompt, int lastOption) {
		int choice = 0;
		boolean validChoice = false;

		while (true) {
			System.out.println();

			System.out.print(prompt);
			String stringChoice = keyboard.next();
			keyboard.nextLine(); // to get rid of any trailing texts

			try {
				choice = Integer.parseInt(stringChoice);
			} catch (NumberFormatException e) {
				System.out.println(" Not a numeric choice. try again.");
				continue;
			}

			validChoice = choice >= 1 && choice <= lastOption; // resets loop condition

			if (!validChoice) {
				System.out.println(" Not an available option. try again.");
				continue;
			} else {
				break;
			}

		}

		return choice;

	}

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
			fleet.flyAll();
			break;

		case 7:
			fleet.flyAll();
			break;

		case 8:
			fleet.flyAll();
			break;

		case 9:
			endProgram();
			break;

		default:
			break;

		}
	}

	private void endProgram() {
		System.out.println("Thanks for using the app. have a great day");
		keyboard.close();
		System.exit(0);
	}

	// created as per instructions
	/*
	 * private void displayUserMenu() { System.out.println(MENU_BORDER);
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("1. List fleet"));
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("2. Fly all jets"));
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("3. View fastest jet"));
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("4. View jet with longest range"));
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("5. View most expensive jet"));
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("6. Load all Cargo Jets"));
	 * System.out.println(SPACE); System.out.println(getMenuOption("7. Dogfight"));
	 * System.out.println(SPACE);
	 * System.out.println(getMenuOption("8. Add a jet to Fleet"));
	 * System.out.println(SPACE); System.out.println(getMenuOption("9. Quit"));
	 * System.out.println(SPACE); System.out.println(MENU_BORDER);
	 * 
	 * }
	 */

}
