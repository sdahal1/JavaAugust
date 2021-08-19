package com.dahal.w3d4beltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dahal.w3d4beltreviewer.models.LoginUser;
import com.dahal.w3d4beltreviewer.models.Meal;
import com.dahal.w3d4beltreviewer.models.User;
import com.dahal.w3d4beltreviewer.services.MealService;
import com.dahal.w3d4beltreviewer.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private MealService mealServ;
	
	
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
		
		
		//ask the service to get all the meals and put it in a variable
		List<Meal> allMeals = this.mealServ.findAllMeals();
		
		//pass that variable to the template
		model.addAttribute("allMeals", allMeals);
		
		return "home.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	
	
	
	
	//show form to create a new meal with
	@GetMapping("/meals/new")
	public String newMeal(@ModelAttribute("meal") Meal meal) {
		
		return "newMeal.jsp";
	}
	
	//form submits to this route to create a new meal object
	@PostMapping("/meals/create")
	public String createMeal(@Valid @ModelAttribute("meal") Meal meal, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "newMeal.jsp";
		}
		
		
		System.out.println(meal.getName());
		System.out.println(meal.getDescription());
		System.out.println(meal.getUploader());
		
		//get the logged in user. first the id of the logged in user is in session, so lets get that (use session!!)
		Long idOfLoggedInUser = (Long)session.getAttribute("user_id");
		
		//after we have the id of the logged in user, we can get the whole logged in user object using that id
		User loggedInUserObj = this.userServ.findUser(idOfLoggedInUser);
		
		
		//set the meals uploader to be that loggedin user object
		meal.setUploader(loggedInUserObj);
		

		this.mealServ.createMeal(meal);
		
		
		
		return "redirect:/home";
	}
	
	@GetMapping("/meal/info/{id}")
	public String showMealInfo(@PathVariable("id")Long id, Model model) {
		//get a meal from the db using the service
		Meal mealobj = this.mealServ.getMeal(id);
		//pass the meal object to the templates
		model.addAttribute("mealobj",mealobj);
		
		
		return "mealinfo.jsp";
	}
	
	
	@GetMapping("/meal/{id}/edit")
	public String editMeal(@PathVariable("id") Long id, Model model) {
		//get a meal object that has the id from the route so that we can send that to the form to pre populate the edit form with info about that meal
		Meal mealobj = this.mealServ.getMeal(id);
		
		//pass the meal object to the form
		model.addAttribute("mealobj", mealobj);
		

		return "editMeal.jsp";
	}
	
	@PostMapping("/meals/{id}/update")
	public String updateMeal(@PathVariable("id") Long id, @Valid @ModelAttribute("mealobj") Meal meal, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "editMeal.jsp";
		}else {
			//get the meal object we want to update from the form 
			System.out.println("**********");
			System.out.println(meal.getName());
			System.out.println(meal.getDescription());
			System.out.println(meal.getId());
			System.out.println(meal.getUploader());
			
			//get the logged in user id using session key user_id
			Long loggedinUserId = (Long) session.getAttribute("user_id");
			
			//get the logged in user OBJECT!!! using the id from session
			User loggedInUserOBJECT = this.userServ.findUser(loggedinUserId);
			
			//assign the meal's uploader to be the logged in user
			meal.setUploader(loggedInUserOBJECT);
//			meal.setId(id);
			
			//pass the meal object to the service to update the db with
			this.mealServ.updateMeal(meal);
			System.out.println("**********");
			
			
			
		}
		
		
		
		
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMeal(@PathVariable("id") Long id) {
		
		this.mealServ.deleteMeal(id);
		
		
		
		return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	 

}

