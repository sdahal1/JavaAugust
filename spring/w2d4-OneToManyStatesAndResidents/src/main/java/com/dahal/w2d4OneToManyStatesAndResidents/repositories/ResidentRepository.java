package com.dahal.w2d4OneToManyStatesAndResidents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w2d4OneToManyStatesAndResidents.models.Resident;



@Repository
public interface ResidentRepository extends CrudRepository<Resident,Long> {

}
