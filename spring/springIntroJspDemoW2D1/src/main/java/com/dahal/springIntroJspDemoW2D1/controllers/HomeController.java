package com.dahal.springIntroJspDemoW2D1.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		
		//i can pass these variables to the templates
		String name = "Logan";
		int numBelts = 40;
		
		model.addAttribute("n", name);
		model.addAttribute("numberOfBelts",numBelts);
//		ArrayList<String> favArtists = new ArrayList()
		String[] favArtists = {"Doja Cat", "Colony House", "Mac Miller", "Kanye", "Taylor Swift", "Slaughtertable"};
		
		model.addAttribute("favArtists", favArtists);
		
		
		return "index.jsp";
	}
	
	
	
	@RequestMapping("/schedule_appointment")
	public String scheduleAppointment(Model model ) {
		//create a variable for the date
		Date date = new Date();
		
		System.out.println(date);
		//pass the variable to the template
		model.addAttribute("today", date);
		
		return "appointment.jsp";
	}
	
//	@RequestMapping(value= "/createAppointment", method=RequestMethod.POST)
	
	
	@PostMapping("/createAppointment")
	public String showResult(@RequestParam("firstname") String firstname, @RequestParam("topic") String topic, @RequestParam("language") String language, Model model ) {
		//I can extract the information form the form in this route b/c the from submitted to this route
//		print(request.form)
		System.out.println(firstname);
		System.out.println(topic);
		System.out.println(language);
		
		model.addAttribute("fname", firstname);
		model.addAttribute("topic", topic);
		model.addAttribute("lang", language);
		
		return "result.jsp";
	}
	
}
