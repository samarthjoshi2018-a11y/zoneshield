package com.example.RegisterationService.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegisterationService.Model.User;
import com.example.RegisterationService.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo urepo;
    
    public Optional<User> finduserbyemail(String email){
        return urepo.findByEmail(email);
    }

    public void saveUser(User user){
        urepo.save(user);
    }

}
