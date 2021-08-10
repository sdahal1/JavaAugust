package com.dahal.w2d2springDataIPets.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w2d2springDataIPets.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
}
