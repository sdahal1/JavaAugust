package com.dahal.w2d2springDataIPets.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dahal.w2d2springDataIPets.models.Pet;
import com.dahal.w2d2springDataIPets.services.PetService;

@RestController
public class PetApi {
	//in the metaphor for the bank...the controller is the customer that comes into the bank. The service is the bank teller. The customer needs to talk to the bank teller.
	
	//let the customer know about the bank teller (let the controller know about the service)
	private final PetService petService;
	
	public PetApi(PetService petService) {
		this.petService= petService;
	}
	
	//the controller is going to have requests
	@RequestMapping("/api/pets")
	public List<Pet>  getAllPets(){
		return this.petService.allPets();
	}
	
	
	//to create a pet
	@PostMapping("/api/pets")
	public Pet createNewPet(@RequestParam(value="name") String name, @RequestParam(value="age") Integer age, @RequestParam("description") String description) {
		
		//create a pet objects using the constructor in the Pet.java model
		Pet p = new Pet(name, age, description);
		
		
		return this.petService.createPet(p);
	}
	
	
	
	
	
	
}
