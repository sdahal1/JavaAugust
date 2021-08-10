package com.dahal.w2d2springDataIPets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dahal.w2d2springDataIPets.models.Pet;
import com.dahal.w2d2springDataIPets.repositories.PetRepository;

@Service
public class PetService {
	
	//tell the service about the repository (telling the bank teller which machine to use to perform transactions/and operations on the vault/safe(db/models)
	private final PetRepository petRepository;
	
	//create a constructor for the service
	public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
	
	
	//training the bank teller how to use the special machine (telling the services how to access the repsitory methods)
	//get all the pets --returns all the pets
    public List<Pet> allPets() {
        return (List<Pet>) this.petRepository.findAll();
    }
    
    //create a new pet
    public Pet createPet(Pet pet) {
    		return this.petRepository.save(pet);
    }
    
    
    
    
    
    

}
