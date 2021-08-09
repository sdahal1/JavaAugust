package com.dahal.springIntroSessionDemoW2D1.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		
//		session['counter'] = 1
		//if the cookie does not exist, then initialize it
		if (session.getAttribute("visitCount") == null) {
			session.setAttribute("visitCount", 1);
		}else { //if the cookie for visitCount tracking already exists, then increment the visit count
			//get the current value from session about visitCount and convert it to integer because session changes up the data types
			Integer currentCount = (Integer) session.getAttribute("visitCount");
			
			//update session about visitCount to be 1 more than previous
			session.setAttribute("visitCount", currentCount+1);
		}
		
		//pass the session information using the view model. The view model is how we pass info from server (controllers) to the templates
		model.addAttribute("visitCount", session.getAttribute("visitCount"));
		
		return "visitCount.jsp";
	}

}
