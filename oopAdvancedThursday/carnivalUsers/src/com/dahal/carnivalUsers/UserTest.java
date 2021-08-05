package com.dahal.carnivalUsers;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User("Kyle", 30, 45);
		User user2 = new User("Timothy", 50, 15);
		User user3 = new User("Alex", 10, 50);
		
		
		user1.displayInfo();
		
		
		System.out.println(User.getTotalNumberOfUsers());
		
		user1.playRiggedBasketbalGame(25);
		user1.displayInfo();
		
		user3.purchaseTokens(20, "game");
		user3.displayInfo();
		
		
		
	}

}
