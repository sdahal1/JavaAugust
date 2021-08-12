package com.dahal.w2d4OneToManyStatesAndResidents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w2d4OneToManyStatesAndResidents.models.State;

@Repository
public interface StateRepository extends CrudRepository<State,Long>{
	
}
