package com.dahal.oopInheritanceDemo;

public class OlympianTest {

	public static void main(String[] args) {
		//create 3 olympians
		Olympian person1 = new Olympian("Michael Phelps", "USA");
		Olympian person2 = new Olympian("Luka Doncic", "Slovenia");
		Olympian person3 = new Olympian("Simone Biles", "USA");
		
		System.out.println(person1);
		
		person2.displayStats();
		
		
		Swimmer swimmer1 = new Swimmer("Caeleb Dressel", "USA", 55);
		
		swimmer1.displayStats();
		
		swimmer1.swim();
		swimmer1.displayStats();
		
		
		WeightLifter lifter1 = new WeightLifter("Brock Lesner", "USA", true );
		lifter1.displayStats();
		
		lifter1.gruntReallyLoudly();
		
		lifter1.displayStats();
		
		
		System.out.println(lifter1.getCountry());
		lifter1.setCountry("Tibet");
		
		lifter1.displayStats();
		

	}

}
