package com.dahal.w3d1manyToMany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dahal.w3d1manyToMany.models.Group;
import com.dahal.w3d1manyToMany.models.User;
import com.dahal.w3d1manyToMany.services.AppService;

@Controller
public class HomeController {
	
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService=appService;
	}

	
	@GetMapping("/")
	public String home(@ModelAttribute("group") Group group) {
		return "index.jsp";
	}
	
	@PostMapping("/groups/create")
	public String createGroup(@Valid @ModelAttribute("group") Group group, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		this.appService.createGroup(group);
		
		
		
		
		return "redirect:/";
		
	}
	
	@GetMapping("/groups/{id}")
	public String showGroupInfo(@PathVariable("id") Long id, Model model) {
		
		//get a group object based on the id from the route and pass to the template
		Group group = this.appService.getOneGroup(id);
		model.addAttribute("group", group);
		
		//get all the users using the service, and pass to the template (for the dropdown)
		List<User> allUsers = this.appService.getAllUsers();
		model.addAttribute("allUsers", allUsers);
		
		
		
		return "groupInfo.jsp";
	}
	
	@PostMapping("/addMembers/{id}")
	public String addMemberToGroup(@PathVariable("id")Long groupId, @RequestParam("userId") Long userId) {
		
		//we have the id of the user in userId variable, and we have the id of group in groupId variable
		System.out.println("GROUP ID IS THIS-->" + groupId);
		System.out.println("USER ID IS THIS-->" + userId);
		
		
		//retrieve a group object using the group id
		Group group = this.appService.getOneGroup(groupId);
		
		
		//retrieve the user object using the user id
		User user = this.appService.getOneUser(userId);
		
		
		//printing to see the members of the group currently
		List<User> currentMembers = group.getMembers();
		System.out.println(currentMembers);
		
		//add selected user to the list of current members for the selected group
		currentMembers.add(user);
		
		System.out.println("Current members after adding the new member");
		System.out.println(currentMembers); //now the list has one more user in it
		
		//set the groups current members to be this new list
		group.setMembers(currentMembers); //now i have a group objects whose members list contains one extra user
		
		
		//now that i have a group object that is updated, i can send it to the service to update the database with
		this.appService.updateGroup(group);
		
		
		return "redirect:/groups/" + groupId;
	}
	
	
	
	
	
	
	
}
