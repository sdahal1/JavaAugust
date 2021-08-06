package com.dahal.spring_intro.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorsPathVariablesController {
	
	//color/violet
	//color/indigo
	//color/blue
	//color/green
	//color/yellow
	//color/orange
	//color/red
	
	@RequestMapping("/color/{colorName}")
	public String showColorInfo(@PathVariable("colorName") String colorName) {
		
		return "The color you selected is: " + colorName;
	}
	
	
	@RequestMapping("/color/{colorName}/{personName}")
	public String showColorInfo(@PathVariable("colorName") String colorName, @PathVariable("personName") String personName  ) {
		
//		return "The color that " + personName + " selected is: " + colorName;
		System.out.println(colorName);
		
		if(colorName.equals("yellow")) {
			return "Look at the stars, Look how they shine for you, And everything you do, Yeah, they were all yellow"; 
		}
		else if(colorName.equals("blue")) {
			return "My favorite color is blue, i like the number 2, and i was wonderin if i can go on a date with you? Trueeeee";
		}
		
		else {
			return "This is another color. that anotha one. Queue DJ Khaled song";
		}
	}
	
	
	
	

}
