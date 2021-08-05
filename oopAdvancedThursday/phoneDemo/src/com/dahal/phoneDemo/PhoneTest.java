package com.dahal.phoneDemo;

public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Iphone stevensPhone = new Iphone("10.5", 100, "Verizon", "Taylor Swift");
		
		stevensPhone.displayInfo();
		
		
		Galaxy julisPhone = new Galaxy("1", 50, "At&t", "Kings of Leon");
		
		julisPhone.displayInfo();
		
		System.out.println(stevensPhone.unlock());
		System.out.println(julisPhone.unlock());
		

	}

}
