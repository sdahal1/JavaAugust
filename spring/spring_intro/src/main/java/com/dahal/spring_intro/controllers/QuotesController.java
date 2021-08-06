package com.dahal.spring_intro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuotesController {
	
	//olympics/summer/basketball
	//olympics/summer/swimming
	
	
	
	//quotes/funny
	@RequestMapping("/funny")
	public String funnyQuotePage() {
		return "What is the most used language in Programming? Profanity! \n Why did the JavaScript actor not get the role in the audition? Because they didn't get a call back!";
	}
	
	
	//quotes/inspirational
	@RequestMapping("/inspirational")
	public String showInspirationalQuotes() {
		return "It isn't the mountains ahead to climb that wear you out; it's the pebble in your shoe";
	}
	
	
	
	//quotes/interesting
	@RequestMapping("/interesting")
	public String interestingQuote() {
		return "Fact: A cow-bison hybrid is called a “beefalo”";
	}

}
