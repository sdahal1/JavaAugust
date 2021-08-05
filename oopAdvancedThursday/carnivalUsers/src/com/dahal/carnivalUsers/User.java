package com.dahal.carnivalUsers;

public class User {
	//member variables
	private String name;
	private int numGameTokens;
	private int numFoodTokens;
	
	//static variable for total number of users created so far
	private static int totalNumberOfUsers=0;
	
	//constructor
	public User(String nameInput, int gameTokenInput, int foodTokenInput) {
		this.name = nameInput;
		this.numGameTokens= gameTokenInput;
		this.numFoodTokens = foodTokenInput;
		totalNumberOfUsers+=1;
		
	}
	
	public void displayInfo() {
		String info = String.format("User Info: \n Name: %s, \n Game Tokens: %s \n Food Tokens: %s", this.name, this.numGameTokens, this.numFoodTokens);
		System.out.println(info);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumGameTokens() {
		return numGameTokens;
	}

	public void setNumGameTokens(int numGameTokens) {
		this.numGameTokens = numGameTokens;
	}

	public int getNumFoodTokens() {
		return numFoodTokens;
	}

	public void setNumFoodTokens(int numFoodTokens) {
		this.numFoodTokens = numFoodTokens;
	}

	public static int getTotalNumberOfUsers() {
		return totalNumberOfUsers;
	}

	public static void setTotalNumberOfUsers(int totalNumberOfUsers) {
		User.totalNumberOfUsers = totalNumberOfUsers;
	}
	
	//more unique methods that users can perform
	//playing a carnival game
	public void playRiggedBasketbalGame(int numGames) {
		//figure out if they have enough tokens to play that number of games, and if they do, then subtract the tokens from their total game tokens, and if they don't have enough tokens, then tell them they dont have enough
		if(this.numGameTokens < numGames) {
			System.out.println("You do not have enough game tokens to get ripped off with this horriblly rigged game");
		}else {
			this.numGameTokens-= numGames;
		}
		
	}
	
	
	//deposit tokens
	public void purchaseTokens(int numTokensToPurchace, String tokenType ) {
		if(tokenType == "game") {
			this.numGameTokens += numTokensToPurchace;
		}else if (tokenType == "food") {
			this.numFoodTokens += numTokensToPurchace;
		}else {
			System.out.println("These are not the tokens you're looking for");
		}
	}
	
	
	
	

}
