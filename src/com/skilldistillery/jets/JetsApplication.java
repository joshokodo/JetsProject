package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	
	private AirField airfield;
	private Scanner keyboard;

	public static void main(String[] args) {
		
		JetsApplication app = new JetsApplication();
		
	}
	
	private JetsApplication() {
		airfield = new AirField();
		keyboard = new Scanner(System.in);
	}
	
	
	private void launch() {
		
	}
	
	private void displayUserMenu() {
		
	}

}
