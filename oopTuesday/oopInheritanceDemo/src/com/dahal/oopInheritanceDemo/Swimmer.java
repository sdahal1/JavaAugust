package com.dahal.oopInheritanceDemo;

public class Swimmer extends Olympian {
	//some features only a swimmer would have
	public int swimSpeed;
	
	
	//constructor for swimmer class
	public Swimmer(String nameInput, String countryInput, int swimSpeedInput) {
		super(nameInput, countryInput);
		this.stamina = 60;
		
	}
	
	//methods that only a swimmer can do
	public void swim() {
		System.out.println("Swimming....");
		this.energyLevel -= 5;
	}

}
