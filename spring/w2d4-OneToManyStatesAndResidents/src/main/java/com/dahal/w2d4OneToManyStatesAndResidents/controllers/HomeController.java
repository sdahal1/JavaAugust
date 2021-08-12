package com.dahal.w2d4OneToManyStatesAndResidents.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dahal.w2d4OneToManyStatesAndResidents.models.Resident;
import com.dahal.w2d4OneToManyStatesAndResidents.models.State;
import com.dahal.w2d4OneToManyStatesAndResidents.services.AppService;

@Controller
public class HomeController {
	
	//let the controller know about the service
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService= appService;
	}
	
	@GetMapping("/")
	public String home(Model model, @ModelAttribute("state") State state) {
		
		List<State> allStates = this.appService.findAllStates();
		model.addAttribute("allStates", allStates);
		return "index.jsp";
	}
	
	
	@PostMapping("/state/create")
	public String createNewState(@Valid @ModelAttribute("state") State state, BindingResult result, Model model) {
//		System.out.println(state);
//		System.out.println(state.getAnimal());
//		System.out.println(state.getName());
		if(result.hasErrors()) {
			List<State> allStates = this.appService.findAllStates();
			model.addAttribute("allStates", allStates);
			return "index.jsp";
		}else {
			
			this.appService.createState(state);
			return "redirect:/";
			
		}
		
	}
	
	//create a resident
	@GetMapping("/residents/new")
	public String newResident(@ModelAttribute("resident") Resident resident, Model model) {
		//pass list of all states to populate the dropdown
		List<State> allStates = this.appService.findAllStates();
		model.addAttribute("allStates", allStates);
		return "newResident.jsp";
	}
	
	@PostMapping("/resident/create")
	public String createResident(@Valid @ModelAttribute("resident") Resident resident, BindingResult result, Model model) {
//		System.out.println(resident);
//		System.out.println(resident.getName());
//		System.out.println(resident.getAge());
//		System.out.println(resident.getState().getName());
		if(result.hasErrors()) {
			List<State> allStates = this.appService.findAllStates();
			model.addAttribute("allStates", allStates);
			return "newResident.jsp";
		}else {
			this.appService.createResident(resident);
			return "redirect:/";
		}
		
		
		
	}
	
	@GetMapping("/state/{id}")
	public String showStateDetails(@PathVariable("id")Long id, Model model) {
		
		State s = this.appService.getOneState(id);
		model.addAttribute("state", s);
		
		return "stateDetails.jsp";
	}
	
	

}
