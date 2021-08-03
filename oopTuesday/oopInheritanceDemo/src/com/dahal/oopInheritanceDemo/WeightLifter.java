package com.dahal.oopInheritanceDemo;

public class WeightLifter extends Olympian {
	//member variables
	public int strength;
	public boolean doesGrunt;
	
	
	//constructor
	public WeightLifter(String nameInput, String countryInput, Boolean gruntInput) {
		super(nameInput, countryInput);
		this.stamina = 15;
		this.strength = 100;
		this.doesGrunt = gruntInput;
	}
	
	
	//display stats method
		public void displayStats() {
			String stats = String.format("Arrrgggg, oh oops there i go grunting again, anyways here are the Stats for this olympian: \n Name: %s, \n Country: %s, \n Number of Medals: %s, \n Stamina: %s, \n Energy Level: %s, \n Strength: %s", this.name, this.country, this.numMedalsWon, this.stamina, this.energyLevel, this.strength  );
			
			System.out.println(stats);
		}
		
		
		public void gruntReallyLoudly() {
			if(this.doesGrunt == true) {
				System.out.println("AAAAARRGGGGGGGG ,, STRING[] ARGS THAT IS....HAW HAW HAWW");
				this.energyLevel += 1000;
			}
		}
		

}
