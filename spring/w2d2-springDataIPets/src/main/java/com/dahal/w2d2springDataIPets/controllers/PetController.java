package com.dahal.w2d2springDataIPets.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahal.w2d2springDataIPets.models.Pet;
import com.dahal.w2d2springDataIPets.services.PetService;

@Controller
public class PetController {
	//tell the controller about the service
	private final PetService petService;
	
	public PetController(PetService petService) {
		this.petService= petService;
	}
	
	@RequestMapping("/pets")
	public String getAllPets(Model model){
		List<Pet> allPets = this.petService.allPets();
		
		model.addAttribute("allPets", allPets);
		
		return "index.jsp";
	}
	
	
}
