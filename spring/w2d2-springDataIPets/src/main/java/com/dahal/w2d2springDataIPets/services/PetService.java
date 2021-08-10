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
    
    
    //find a pet given an id
    public Pet findOnePet(Long id) {
    		return this.petRepository.findById(id).orElse(null);
    		
    		
    		//another OPTION (haha) is to have the below code to retrieve a pet object from the database using the repository
    		
//    		Optional<Pet> optionalPet = this.petRepository.findById(id);
//            if(optionalPet.isPresent()) {
//                return optionalPet.get();
//            } else {
//                return null;
//            }
    		
    }
    
    //delete a pet given an id
    public void deletePet(Long id) {
    		this.petRepository.deleteById(id);
    }
    
    
    //update a pet givne an id
    public Pet updatePet(Pet p) {
    		return this.petRepository.save(p);
    		
    }
    
    
    //another way to update a pet
    public Pet updatePetAnotherWay(Long id, String name, String description, Integer age) {
    		//retrieve a pet object from the db that has that id
    		Pet p = this.findOnePet(id);
		System.out.println("***********");
		System.out.println(p.getName());
		System.out.println("***********");
		
		
		//update that object
		System.out.println(name);
		p.setName(name);
		p.setAge(age);
		p.setDescription(description);
		return this.petRepository.save(p);
		
}
    
    
    
    
    
    

}
