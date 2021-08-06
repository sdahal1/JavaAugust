package com.dahal.spring_intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //this annotation gives us the features of using this classs to handle request response cycles
public class SpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}
	//this is how its done in flask
//	@app.route("/")
//	def index():
//		return "hello"
	
	@RequestMapping("/")
	public String homePage() {
		return "Hello Java World!";
	}
	
	@RequestMapping("/fancy")
	public String ohYouFancyHuh() {
		return "Bonjour le monde";
	}
	
	
	
	
	
	
	

}
