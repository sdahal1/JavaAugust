package com.dahal.w3d4beltreviewer.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dahal.w3d4beltreviewer.models.LoginUser;
import com.dahal.w3d4beltreviewer.models.User;
import com.dahal.w3d4beltreviewer.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
    

    //this is a service method, we decided to name it "register". This service method also handles some more validations that we need to perform to create/register a new user
    public User register(User newUser, BindingResult result) {
    		//this validation is to make sure the email of the new user trying to register is an email that is not already taken. Email must be unique!
        if(this.userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        
        //this validation is to make sure the password and confirmpassword match
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        
        
        if(result.hasErrors()) {
            return null;
        } else {
        		//if the form is filled out properly and the extra validation requirements are met (unique email, and matching pw with confirm)--> then hash the user's password that was typed in the form using Bcrypt and set the users password to be the hashed version of the password
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser); //save the user object to database
        }
    }
    
    
    
    
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        
        //here we are checking if we can find a user in the database who has the email that was typed in the login form
        Optional<User> potentialUser = this.userRepo.findByEmail(newLogin.getEmail());
        
        //if the user with the login email does not exist, then create a validation message sayiing the email is not found
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        //get the user object that was found from the db who has that email from the login form
        User user = potentialUser.get();
        
        //use bcrypt to check if the user object from db has a password that matched the one from the form (the form object is represented by newLogin variable)
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");//if the password does not match, create another validation error message
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    
    public User findUser(Long id) {
    		return this.userRepo.findById(id).orElse(null);
    }
    
}
