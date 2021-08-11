package com.dahal.w2d2springDataIPets.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dahal.w2d2springDataIPets.models.Pet;
import com.dahal.w2d2springDataIPets.services.PetService;

@Controller
public class PetController {
	//tell the controller about the service
	private final PetService petService;
	
	public PetController(PetService petService) {
		this.petService= petService;
	}
	
	@GetMapping("/pets")
	public String getAllPets(Model model){
		List<Pet> allPets = this.petService.allPets();
		
		model.addAttribute("allPets", allPets);
		
		return "index.jsp";
	}
	
	@GetMapping("/pets/new")
	public String newPet(@ModelAttribute("pet") Pet pet) {
	
		return "newPet.jsp";
		
	}
	
	@PostMapping("/pet/create")
	public String createPet(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
		if(result.hasErrors()) {
			return "newPet.jsp";
		}
		System.out.println(pet.getName());  //request.from[name]
		System.out.println(pet.getDescription()); //request.form['descrioption]
		System.out.println(pet.getAge());
		
		this.petService.createPet(pet);
		
		return "redirect:/pets";
		
	}
	
	@GetMapping("/pet/info/{id}")
	public String showPetInfo(@PathVariable("id") Long id, Model model) {
		//using the id coming from the route, we can request from the service to return to us a pet object that has that id
		Pet p = this.petService.findOnePet(id);
		
		model.addAttribute("petToDisplay", p);
		
		
		return "petinfo.jsp";
	}
	
	@GetMapping("/pet/edit/{id}")
	public String editPet(@PathVariable("id") Long id, Model model) {
		//get a pet object so we can send that pet to the edit form to prepopulate with this pets info
		Pet p = this.petService.findOnePet(id);
		
		model.addAttribute("pett", p);
		
		return "editPet.jsp";
	}
	
	@PostMapping("/pet/update/{id}")
	public String updatePet(@PathVariable("id") Long id, @Valid @ModelAttribute("pett") Pet pet, BindingResult result  ) {
		if(result.hasErrors()) {
			return "editPet.jsp";
		}
		//if the form doesnt have errors and is filled out properly, then update the pet object
//		this.petService.updatePetAnotherWay(id, pet.getName(), pet.getDescription(), pet.getAge());
		
		System.out.println(pet.getId());
		System.out.println(pet.getName());
		
		
		this.petService.updatePet(pet);
		
		return "redirect:/pets";
	}
	
	
	@GetMapping("/pet/delete/{id}")
	public String deletePet(@PathVariable("id") Long id) {
		
		this.petService.deletePet(id);
		
		return "redirect:/pets";
	}
	
	
	
	
	
	
}
