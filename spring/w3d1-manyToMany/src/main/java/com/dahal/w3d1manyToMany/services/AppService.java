package com.dahal.w3d1manyToMany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dahal.w3d1manyToMany.models.Group;
import com.dahal.w3d1manyToMany.models.User;
import com.dahal.w3d1manyToMany.repositories.GroupRepository;
import com.dahal.w3d1manyToMany.repositories.UserRepository;

@Service
public class AppService {
	
	
	private final UserRepository userRepo;
	private final GroupRepository groupRepo;
	
	public AppService(UserRepository userRepo, GroupRepository groupRepo ) {
		this.userRepo = userRepo;
		this.groupRepo = groupRepo;
	}
	
	
	//service methods below
	public Group createGroup(Group group) {
		return this.groupRepo.save(group);
	}
	
	public Group getOneGroup(Long id) {
		return this.groupRepo.findById(id).orElse(null);
	}
	
	public List<User> getAllUsers(){
		return (List<User>)this.userRepo.findAll();
	}
	
	public User getOneUser(Long id) {
		return this.userRepo.findById(id).orElse(null);
	}
	
	public void updateGroup(Group g) {
		this.groupRepo.save(g);
	}
	
	
	
	

}
