package com.skilldistillery.jets.app;

import java.nio.file.attribute.UserPrincipalLookupService;

import com.skilldistillery.myutils.AbstractUI;

public class JetsApplicationUI extends AbstractUI {

	private static final String MAIN_MENU_HEADER_1 = "Welcome to the Jets app. Choose an option below.";
	private static final String MAIN_MENU_OPTION_1 = "1. List fleet";
	private static final String MAIN_MENU_OPTION_2 = "2. Fly all Jets";
	private static final String MAIN_MENU_OPTION_3 = "3. View fastest Jet";
	private static final String MAIN_MENU_OPTION_4 = "4. View Jet with longest range";
	private static final String MAIN_MENU_OPTION_5 = "5. View most expensive Jet";
	private static final String MAIN_MENU_OPTION_6 = "6. Load all cargo Jets";
	private static final String MAIN_MENU_OPTION_7 = "7. Dogfight";
	private static final String MAIN_MENU_OPTION_8 = "8. Add a jet to Fleet";
	private static final String MAIN_MENU_OPTION_0 = "0. Exit app";
	
	private static final String CUSTOM_JET_HEADER_1 = "Choose a type of Jet to custom build";
	private static final String CUSTOM_JET_OPTION_1 = "1. Figher Jet";
	private static final String CUSTOM_JET_OPTION_2 = "2. Cargo Jet";
	private static final String CANCEL_OPTION_1 = "Cancel";
	
	private static final String HANGER_FULL_WARNING_1 = "Can't add Jet. Hanger full!";
	private static final String JET_ADDED_TO_HANGER_UPDATE_1 = "Jet added to Fleet.";
	
	
	private static final String ENTER_MODEL_PROMPT = "Enter Model";
	private static final String ENTER_SPEED_PROMPT = "Enter Speed";
	private static final String ENTER_RANGE_PROMPT = "Enter Range";
	private static final String ENTER_PRICE_PROMPT = "Enter Price";
	
	private static final String EXIT_PROGRAM_MESSAGE = "Thanks for using the Jets app. have a great day";
	
	
	public int mainMenuPrompt() {
		setAsMainMenuUI();
		printUI();
		return getIntInputFromUser(0, 8);
	}
	
	public int customJetPrompt() {
		setAsCustomJetUI();
		printUI();
		return getIntInputFromUser(1, 3);
	}
	
	public void printHangerFullWarning() {
		setAsSingleHeaderUI(HANGER_FULL_WARNING_1);
		printUI();
	}
	public void printJetAddedUpdate() {
		setAsSingleHeaderUI(JET_ADDED_TO_HANGER_UPDATE_1);
		printUI();
	}
	
	public String enterModelPrompt() {
		setAsSingleHeaderUI(ENTER_MODEL_PROMPT);
		printUI();
		return getStringInputFromUser();
	}
	public double enterSpeedPrompt() {
		setAsSingleHeaderUI(ENTER_SPEED_PROMPT);
		printUI();
		return getDoubleInputFromUser();
	}
	public int enterRangePrompt() {
		setAsSingleHeaderUI(ENTER_RANGE_PROMPT);
		printUI();
		return getIntInputFromUser();
	}
	public int enterPricePrompt() {
		setAsSingleHeaderUI(ENTER_PRICE_PROMPT);
		printUI();
		return getIntInputFromUser();
	}
	
	public void printExitProgram() {
		setAsSingleHeaderUI(EXIT_PROGRAM_MESSAGE);
		printUI();
		
	}
	
	
	
	// set UI methods
	private void setAsMainMenuUI() {
		clearLines();
		addBorder();
		addSpace();
		addCenterAlignedText(MAIN_MENU_HEADER_1);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_1);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_2);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_3);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_4);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_5);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_6);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_7);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_8);
		addSpace();
		addLeftAlignedText(MAIN_MENU_OPTION_0);
		addSpace();
		addBorder();
		
	}
	
	private void setAsCustomJetUI() {
		clearLines();
		
		addBorder();
		addSpace();
		addCenterAlignedText(CUSTOM_JET_HEADER_1);
		addSpace();
		addLeftAlignedText(CUSTOM_JET_OPTION_1);
		addSpace();
		addLeftAlignedText(CUSTOM_JET_OPTION_2);
		addSpace();
		addLeftAlignedText("3. " + CANCEL_OPTION_1);
		addSpace();
		addBorder();
	}
	
	private void setAsSingleHeaderUI(String header) {
		clearLines();
		addBorder();
		addSpace();
		addCenterAlignedText(header);
		addSpace();
		addBorder();
	}

}
