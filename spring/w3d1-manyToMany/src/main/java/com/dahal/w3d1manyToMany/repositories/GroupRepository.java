package com.dahal.w3d1manyToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w3d1manyToMany.models.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long>{

}
