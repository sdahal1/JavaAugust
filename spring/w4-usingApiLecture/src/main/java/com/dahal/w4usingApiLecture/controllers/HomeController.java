package com.dahal.w4usingApiLecture.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) throws Exception , JsonParseException, IOException {
		
		// Host url
	      String host = "https://newsapi.org/v2/everything?q=meditation&apiKey=dc3063ef0bce4718a88a3ac000ec7448";
	      String charset = "UTF-8";
	      
	      
	      //make the request
	      HttpResponse <JsonNode> response = Unirest.get(host).asJson();
	      System.out.println("PRINTING THE RESPONSE .GETSTATUS THING ***********");
	      System.out.println(response.getBody());
	      
	      JsonNode body = response.getBody();
	      
	      
	      
	    //Prettifying
	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
	      
	      JsonParser jp = new JsonParser();
	      JsonElement je = jp.parse(response.getBody().toString());
	      String prettyJsonString = gson.toJson(je);
//	      System.out.println(prettyJsonString);
	      ObjectMapper mapper = new ObjectMapper();
	      com.fasterxml.jackson.databind.JsonNode actualObj = mapper.readTree(prettyJsonString);
	      
	      System.out.println("!!!!!!!!!!!!!!");
	      System.out.println(actualObj.get("articles"));
	      
	      com.fasterxml.jackson.databind.JsonNode articles = actualObj.get("articles");
	      
	      ArrayNode arrayNode = (ArrayNode) mapper.readTree(prettyJsonString).get("articles");
	      
	      
//	      arrayNode.size()
	      
	      for(int i = 0; i< arrayNode.size(); i++) {
	    	  System.out.println(arrayNode.get(i).get("author"));
	      }
	      
	      
	      //pass to template
	      model.addAttribute("actualObj", actualObj);
	      model.addAttribute("articles", arrayNode);
		
		return "home.jsp";
	}
}
