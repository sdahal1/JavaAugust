package com.dahal.w3d2loginregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w3d2loginregistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
