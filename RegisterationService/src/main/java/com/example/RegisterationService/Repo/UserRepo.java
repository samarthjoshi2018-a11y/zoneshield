package com.example.RegisterationService.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RegisterationService.Model.User;

public interface UserRepo extends JpaRepository<User, String>{

    public Optional<User> findByEmail(String email);
}
