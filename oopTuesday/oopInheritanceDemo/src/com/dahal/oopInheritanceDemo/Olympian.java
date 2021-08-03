package com.dahal.oopInheritanceDemo;

public class Olympian {
	//member variables
	public String name;
	public String country;
	public int numMedalsWon;
	public int stamina;
	public int energyLevel;
	
	//constructor
	public Olympian(String nameInput, String countryInput ) {
		this.name = nameInput;
		this.country = countryInput;
		this.numMedalsWon = 0;
		this.stamina = 30;
		this.energyLevel = 100;
	}
	
	//display stats method
	public void displayStats() {
		String stats = String.format("Stats for this olympian: \n Name: %s, \n Country: %s, \n Number of Medals: %s, \n Stamina: %s, \n Energy Level: %s", this.name, this.country, this.numMedalsWon, this.stamina, this.energyLevel  );
		
		System.out.println(stats);
		
		
	}
	

}
