package com.dahal.w3d2loginregistration.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dahal.w3d2loginregistration.models.LoginUser;
import com.dahal.w3d2loginregistration.models.User;
import com.dahal.w3d2loginregistration.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	
//	@GetMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	
	@GetMapping("/")
    public String index(Model model) {
		
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		
		//we are sending the model that was filled out from the form (containing username, email, pw, and confirm) to the service for additional validations
        this.userServ.register(newUser, result);
        
        
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
		
        User user = this.userServ.login(newLogin, result); //the service method login will either return null if there are validation errors, or it will return a whole user object from the db that the user is trying to log in as
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
	
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		Long loggedInUserId = (Long)session.getAttribute("user_id");
		System.out.println("PRINTING THE LOGGED IN USER ID!!!");
		System.out.println(loggedInUserId);
		
		if(loggedInUserId == null) {
			//generate a flash message to show on the redirect
			redirectAttributes.addFlashAttribute("notAllowed", "You must log in first!");
			return "redirect:/";
		}
		
		//use the id from session to find a user in our database that has that id, so we can pass that user to the template 
		User loggedInUser = this.userServ.findUser(loggedInUserId);
//		System.out.println(loggedInUser);
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "home.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	
	
	 

}
