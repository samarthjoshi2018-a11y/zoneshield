package com.example.RegisterationService.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegisterationService.Model.User;
import com.example.RegisterationService.Services.RegisterEmailProducer;
import com.example.RegisterationService.Services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    private final  RegisterEmailProducer p;

    @Autowired
    private UserService uservice;
        
    public UserController(RegisterEmailProducer p) {
        this.p = p;
    }
    
    @PostMapping("/register")
    public String registerUser(@RequestHeader("X-User") String email,@RequestBody String name) {
        Optional<User> user=uservice.finduserbyemail(email);


        if(user.isPresent()){
            return "Email already exist. Log in to continue";
        }

         User u=new User(name,email,"none");        
        uservice.saveUser(u);

        p.SendUserEvent(email);

       
        
        return " User Registered succesfully";
    }
    
    
    

}
