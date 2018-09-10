package com.skilldistillery.jets;

public abstract class Person {
	
	private String name;
	private int age;
	
	public Person() {
		name = getRandomName();
		age = getRandomInt(18, 65);
	}
	
	


	@Override
	public String toString() {
		return "[name: " + name + " age: " + age + " ";
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	private String getRandomName() {
		
		String[] names = {
				"Rebekah Ruble",
				"Chrystal Chong",
				"Isis Iskra",
				"Guadalupe Galbraith",
				"Natividad Nierman",
				"Arletha Aslett",
				"Tarah Truesdale",
				"Winford Waid",
				"Mabelle Mounts",
				"Colin Carbonneau",
				"Maritza Mijangos",
				"Vernia Varney",
				"Victor Vang",
				"Michel Maycock",
				"Marisela Moskowitz",
				"Nell Nanez",
				"Terence To",
				"Ferne Fogarty",
				"Evangeline Eisner",
				"Porsha Peck"
				
						 };
		
		int winner = getRandomInt(0, 19);
		
		return names[winner];
	}
	
	public int getRandomInt(int min, int max){ 
		return ((int) (Math.random()*(max - min))) + min; 
	}


}
