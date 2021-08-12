package com.dahal.w2d4OneToManyStatesAndResidents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dahal.w2d4OneToManyStatesAndResidents.models.Resident;
import com.dahal.w2d4OneToManyStatesAndResidents.models.State;
import com.dahal.w2d4OneToManyStatesAndResidents.repositories.ResidentRepository;
import com.dahal.w2d4OneToManyStatesAndResidents.repositories.StateRepository;

@Service
public class AppService {
	
	//service needs to know about the repositories
	private final ResidentRepository residentRepo;
	private final StateRepository stateRepo;
	

	//constructor for the service to initialize the repos
	public AppService(ResidentRepository residentRepo, StateRepository stateRepo) {
		this.residentRepo = residentRepo;
		this.stateRepo = stateRepo;
	}
	
	
	//methods that the service can handle
	public List<State> findAllStates(){
		return (List<State>)this.stateRepo.findAll();
	}
	
	
	public State createState(State s) {
		return this.stateRepo.save(s);
	}
	
	
	public Resident createResident(Resident r) {
		return this.residentRepo.save(r);
	}
	
	public State getOneState(Long id) {
		return this.stateRepo.findById(id).orElse(null);
	}
	
	
	
}
