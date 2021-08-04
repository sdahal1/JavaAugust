package com.dahal.oopInheritanceDemo;

public class Olympian {
	//member variables
	protected String name;
	protected String country;
	protected int numMedalsWon;
	protected int stamina;
	protected int energyLevel;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getNumMedalsWon() {
		return numMedalsWon;
	}

	public void setNumMedalsWon(int numMedalsWon) {
		this.numMedalsWon = numMedalsWon;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
	

}
