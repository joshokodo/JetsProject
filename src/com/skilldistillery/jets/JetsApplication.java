package com.skilldistillery.jets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JetsApplication {

	// constant strings for menu
	private final String MENU_BORDER = "****************************************";
	private final String SPACE = "*                                      *";

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
		
		fleet.addJet(new FighterJet("F57", 50.0, 1000, 125_000_000));
	}

	// other methods
	private void launch() {
		int choice = 0;
		
		displayUserMenu();
		choice = getUserChoice();
		performOption(choice);
		keyboard.close();
	}

	private void displayUserMenu() {
		System.out.println(MENU_BORDER);
		System.out.println(SPACE);
		System.out.println(getMenuOption("1. List fleet"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("2. Fly all jets"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("3. View fastest jet"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("4. View jet with longest range"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("5. Load all Cargo Jets"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("6. Dogfight"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("7. Add a jet to Fleet"));
		System.out.println(SPACE);
		System.out.println(getMenuOption("8. Quit"));
		System.out.println(SPACE);
		System.out.println(MENU_BORDER);

	}

	private String getMenuOption(String option) {
		String returnValue = String.format("* %-37s*", option);
		return returnValue;
	}
	
	private int getUserChoice() {
		int choice = 0;
		boolean validChoice = choice >= 1 && choice <= 8;
		
		while(!validChoice) {
			
			try {
				
				choice = keyboard.nextInt();
				validChoice = choice >= 1 && choice <= 8; // resets loop condition
				
				if(!validChoice) {
					System.out.println("Not an available option. try again.");
					continue;
				}
				
			} catch(InputMismatchException e) {
				
				System.out.println("Not a valid choice try again.");
				keyboard.nextLine(); // refreshes scanner to prevent infinite loop
			}
		}
		
		return choice;
		
	}
	
	private void performOption(int choice) {
		
		switch(choice) {
			case 1: fleet.listJets();
					break;
			
			default: 
					break;
				
				
		}
	}
	
	

}
