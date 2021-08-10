package com.dahal.w2d2springDataIPets.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	//get one pet based on an id
	@GetMapping("/api/pets/{id}")
	public Pet findAPet(@PathVariable("id") Long id) {
		return this.petService.findOnePet(id);
	}
	
	
	@DeleteMapping("/api/pets/delete/{id}")
	public void deletePet(@PathVariable("id") Long id) {
		this.petService.deletePet(id);
	}
	
	//one way to update
	@PutMapping("/api/pets/update/{id}")
	public Pet updatePet(@PathVariable("id")Long id, @RequestParam(value="name") String name, @RequestParam(value="age") Integer age, @RequestParam("description") String description) {
		//retrieve a pet object from the db that has that id
		Pet p = this.petService.findOnePet(id);
		System.out.println("***********");
		System.out.println(p.getName());
		System.out.println("***********");
		//update that object
		System.out.println(name);
		
		p.setName(name);
		p.setAge(age);
		p.setDescription(description);
		
		
		//send the updated object to service to update the db with
		return this.petService.updatePet(p);
		
		
	}
	
	
	//another way to update
	@PutMapping("/api/pets/updateV2/{id}")
	public Pet updatePetV2(@PathVariable("id")Long id, @RequestParam(value="name") String name, @RequestParam(value="age") Integer age, @RequestParam("description") String description) {

		
		return this.petService.updatePetAnotherWay(id, name, description, age);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
