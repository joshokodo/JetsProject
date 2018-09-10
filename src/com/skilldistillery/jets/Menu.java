package com.skilldistillery.jets;

import java.util.Scanner;

public interface Menu {
	// constant strings for menu and input
	    final Scanner keyboard = new Scanner(System.in);
		final String MENU_BORDER = "****************************************\n";
		final String SPACE = "*                                      *\n";
		
		 String getUserMenu();
		 
		// returns a formatted menu option line
		default String getMenuOption(String option) {
			String returnValue = String.format("* %-37s*%n", option);
			return returnValue;
		}
		default String getMenuHeader(String option) {
			//TODO make left and right constants 
			// TODO along with menu line length 
			int left = 19, right = 19;
			int length = option.length();
			
			for(int i = 1; i <= length; i++) {
				
				if(i % 2 == 0) {
					
					left--;
				}
				else {
					
					right--;
				}
			}
			
			String returnValue = String.format("*%" + left + "s%s%-" + right + "s*%n", "", option, "");
			return returnValue;
		}
		// prompts users with custom menu(arg 1) of choices
		// between a custom range(arg 2) returns choice in the form of an int
		default int getUserChoice(String prompt, int optionRange) {
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
		
		// scanner input methods
		default int getIntInput() {
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

		default String getStringInput() {
			return keyboard.nextLine();
		}

		default double getDoubleInput() {
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

		default long getLongInput() {
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
		
		default void closeKeyboard() {
			keyboard.close();
		}

}
