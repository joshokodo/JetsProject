package com.skilldistillery.jets.app;
import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	private AirField fleet;
	private int userChoice;
	private JetsApplicationUI ui;

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();
		app.launch();
	}

	// constructor
	private JetsApplication() {
		fleet = new AirField(5);
		ui = new JetsApplicationUI();
		userChoice = -1;
	}

	// launch app method
	private void launch() {
		while(userChoice != 0) {
			userChoice = ui.mainMenuPrompt();
			performOption(userChoice);
		}

	}

	// prompts user for what type of jet to build
	// then asks for all of its fields, builds the
	// specified jet object and adds it to fleet.
	private void addCustomJet() {

		if (hangerFull()) {
			ui.printHangerFullWarning();
			return;
		}

		userChoice = ui.customJetPrompt();

		if (userChoice == 3) {
			return;
		}
		String model = ui.enterModelPrompt();

		double speed = ui.enterSpeedPrompt();

		int range = ui.enterRangePrompt();

		long price = ui.enterPricePrompt();

		if (userChoice == 2) {
			fleet.addJet(new CargoPlane(model, speed, range, price));
		} else if (userChoice == 1) {
			fleet.addJet(new FighterJet(model, speed, range, price));
		}
		ui.printJetAddedUpdate();
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
			case 0 :
				endProgram();
				break;

			case 1 :
				fleet.listJets();
				break;

			case 2 :
				fleet.flyAll();
				break;

			case 3 :
				System.out.println("Fastest jet is...");
				System.out.println(fleet.findFastestJet());

				break;

			case 4 :
				System.out.println("Jet with the longest range is...");
				System.out.println(fleet.findLongestRangeJet());
				break;

			case 5 :
				System.out.println("Most expensive jet... ");
				System.out.println(fleet.findMostExpensiveJet());
				break;

			case 6 :
				fleet.loadAllTheCargo();
				break;

			case 7 :
				fleet.fightAllTheFights();
				break;

			case 8 :
				addCustomJet();
				break;

			default :
				break;

		}
	}

	// thanks user for using app, closes scanner and exits the app
	public void endProgram() {
		ui.printExitProgram();
		ui.closeKeyboard();
		System.exit(0);
	}

}
