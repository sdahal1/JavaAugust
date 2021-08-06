package com.dahal.spring_intro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsQueryParametersController {
	
	@RequestMapping("/pets")
	public String petHomePage(@RequestParam(value="p", required=false) String petName) {
		
		System.out.println(petName);
		
		if(petName==null) {
			return "Dogs are the best pets of all time. This dog does not have a name and we do not know its breed";
		}else {
			return "Dogs are the best pets of all time. This dog's name is " + petName + " and we do not know its breed";
		}
		
	}

}
