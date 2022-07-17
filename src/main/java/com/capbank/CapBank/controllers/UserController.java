package com.capbank.CapBank.controllers;

import com.capbank.CapBank.service.UserService;
import com.capbank.CapBank.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createUser(){
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id){

    }

    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }
}
